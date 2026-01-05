package tumblrApi;

import java.util.ArrayList;
import java.util.List;

public class TumblrViewerMain {

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        TumblrApiClient client = new TumblrApiClient();

        try {
            String blogName = ui.getBlogName();
            String rangeInput = ui.getRange();

            int[] range = parseRange(rangeInput);
            int start = range[0];
            int end = range[1];

            // Tumblr API uses zero-based indexing
            int apiStart = start - 1;
            int totalToFetch = end - start + 1;

            int currentStart = apiStart;
            int remaining = totalToFetch;

            Blog blogInfo = null;
            boolean firstCall = true;

            List<Post> collectedPosts = new ArrayList<>();

            while (remaining > 0) {
                int batchSize = Math.min(remaining, 50);

                String json = client.fetchJson(blogName, currentStart, batchSize);

                if (firstCall) {
                    blogInfo = client.parseBlogInfo(json);
                    ui.printBlogDetails(blogInfo);
                    firstCall = false;
                }

                List<Post> posts = client.parsePosts(json);
                collectedPosts.addAll(posts);

                currentStart += batchSize;
                remaining -= batchSize;

                if (posts.isEmpty()) break;
            }

            ui.printPosts(collectedPosts);

        } catch (Exception e) {
            ui.printError("Something went wrong: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static int[] parseRange(String input) {
        String[] parts = input.split("-");
        if (parts.length != 2) {
            throw new IllegalArgumentException(
                    "Range format is invalid. Use: start-end (example: 1-5)");
        }

        try {
            int start = Integer.parseInt(parts[0].trim());
            int end = Integer.parseInt(parts[1].trim());

            if (start < 1 || end < start) {
                throw new IllegalArgumentException("Range values are not valid.");
            }
            return new int[]{start, end};

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Range must contain numbers only.");
        }
    }
}
