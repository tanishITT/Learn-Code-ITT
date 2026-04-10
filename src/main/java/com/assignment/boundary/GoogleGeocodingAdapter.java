package com.assignment.boundary;

import com.assignment.domain.Coordinate;
import com.assignment.domain.GeocodingException;
import com.assignment.domain.GeocodingProvider;
import com.assignment.domain.Location;
import com.google.gson.Gson;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

public class GoogleGeocodingAdapter implements GeocodingProvider {
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/geocode/json?address=%s&key=%s";
    private static final String STATUS_OK = "OK";
    private static final String STATUS_ZERO_RESULTS = "ZERO_RESULTS";
    private static final int HTTP_OK = 200;

    private final String apiKey;
    private final HttpClient httpClient;
    private final Gson gson;

    public GoogleGeocodingAdapter(String apiKey) {
        if (apiKey == null || apiKey.isBlank() || apiKey.equals("YOUR_API_KEY_HERE")) {
            throw new IllegalArgumentException("A valid Google Maps API key is required.");
        }
        this.apiKey = apiKey;
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    @Override
    public List<Location> geocode(String address) throws GeocodingException {
        if (address == null || address.isBlank()) {
            return Collections.emptyList();
        }

        try {
            String encodedAddress = URLEncoder.encode(address, StandardCharsets.UTF_8);
            String requestUrl = String.format(BASE_URL, encodedAddress, this.apiKey);

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(requestUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != HTTP_OK) {
                throw new GeocodingException("Geocoding request failed. HTTP status: " + response.statusCode());
            }

            GoogleGeocodingResponse parsedResponse = gson.fromJson(response.body(), GoogleGeocodingResponse.class);

            if (!STATUS_OK.equals(parsedResponse.status()) && !STATUS_ZERO_RESULTS.equals(parsedResponse.status())) {
                String detail = parsedResponse.errorMessage() != null ? parsedResponse.errorMessage() : parsedResponse.status();
                throw new GeocodingException("Google API error: " + detail);
            }

            if (parsedResponse.results() == null || parsedResponse.results().isEmpty()) {
                return Collections.emptyList();
            }

            return parsedResponse.results().stream()
                    .map(this::toLocation)
                    .toList();

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new GeocodingException("Request was interrupted.", e);
        } catch (GeocodingException e) {
            throw e;
        } catch (Exception e) {
            throw new GeocodingException("Unexpected error while contacting the geocoding service.", e);
        }
    }

    private Location toLocation(GoogleGeocodingResponse.Result result) {
        Coordinate coordinate = new Coordinate(
                result.geometry().location().lat(),
                result.geometry().location().lng()
        );
        return new Location(result.formattedAddress(), coordinate);
    }
}
