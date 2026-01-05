package tumblrApi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages interaction with the Tumblr API.
 * Fetches raw data and extracts useful information from it.
 */
public class TumblrApiClient {

    private static final String API_URL_TEMPLATE =
            "https://%s.tumblr.com/api/read/json?type=photo&num=%d&start=%d";

    public String fetchJson(String blogName, int start, int num) throws Exception {
        String urlString = String.format(API_URL_TEMPLATE, blogName, num, start);
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != 200) {
            throw new RuntimeException("HTTP request failed with code: " + connection.getResponseCode());
        }

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(connection.getInputStream()));

        StringBuilder responseBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            responseBuilder.append(line);
        }

        connection.disconnect();

        String response = responseBuilder.toString();

        // Clean JS wrapper added by Tumblr API
        if (response.startsWith("var tumblr_api_read = ")) {
            response = response.replace("var tumblr_api_read = ", "");
        }
        if (response.endsWith(";")) {
            response = response.substring(0, response.length() - 1);
        }
        return response;
    }

    public Blog parseBlogInfo(String jsonResponse) {
        String title = extractValue(jsonResponse, "\"title\":\"", "\"");
        String name = extractValue(jsonResponse, "\"name\":\"", "\"");
        String description = extractValue(jsonResponse, "\"description\":\"", "\"");
        String totalPostsStr = extractValue(jsonResponse, "\"posts-total\":", ",");

        int totalPosts = 0;
        try {
            totalPosts = Integer.parseInt(totalPostsStr.trim());
        } catch (NumberFormatException ignored) {
        }

        return new Blog(title, name, description, totalPosts);
    }

    public List<Post> parsePosts(String jsonResponse) {
        List<Post> posts = new ArrayList<>();

        // Each post begins with {"id": in the response
        String[] rawPosts = jsonResponse.split("\\{\"id\":");

        // Skip header section before first post
        for (int i = 1; i < rawPosts.length; i++) {
            String rawPost = rawPosts[i];

            String id = rawPost.split(",")[0].replace("\"", "");
            List<String> images =
                    extractAllMatches(rawPost, "\"photo-url-1280\":\"", "\"");

            if (!images.isEmpty()) {
                posts.add(new Post(id, images));
            }
        }

        return posts;
    }

    private String extractValue(String source, String startMarker, String endMarker) {
        int start = source.indexOf(startMarker);
        if (start == -1) return "N/A";

        start += startMarker.length();
        int end = source.indexOf(endMarker, start);
        if (end == -1) return "N/A";

        return source.substring(start, end);
    }

    private List<String> extractAllMatches(String source, String startMarker, String endMarker) {
        List<String> values = new ArrayList<>();
        int index = 0;

        while (true) {
            int start = source.indexOf(startMarker, index);
            if (start == -1) break;

            start += startMarker.length();
            int end = source.indexOf(endMarker, start);
            if (end == -1) break;

            String value = source.substring(start, end).replace("\\/", "/");
            values.add(value);

            index = end;
        }
        return values;
    }
}
