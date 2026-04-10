package com.assignment.app;

import com.assignment.domain.GeocodingException;
import com.assignment.domain.GeocodingProvider;
import com.assignment.domain.Location;

import java.util.List;
import java.util.Scanner;

public class GeocodingConsoleApp {
    private final GeocodingProvider geocodingProvider;

    public GeocodingConsoleApp(GeocodingProvider geocodingProvider) {
        this.geocodingProvider = geocodingProvider;
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("\nEnter a place to look up (or 'exit' to quit): ");
                String userInput = scanner.nextLine().trim();

                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Shutting down. Goodbye!");
                    break;
                }

                if (userInput.isEmpty()) {
                    System.out.println("Input cannot be blank. Please try again.");
                    continue;
                }

                handleLookup(userInput);
            }
        }
    }

    private void handleLookup(String placeName) {
        System.out.println("Fetching coordinates for '" + placeName + "'...");
        try {
            List<Location> locations = geocodingProvider.geocode(placeName);

            if (locations.isEmpty()) {
                System.out.println("No matches found for the given input.");
                return;
            }

            System.out.println("\n--- Matches ---");
            for (int i = 0; i < locations.size(); i++) {
                System.out.printf("Match #%d:\n%s\n", (i + 1), locations.get(i).toString());
            }
        } catch (GeocodingException e) {
            System.err.println("Geocoding failed: " + e.getMessage());
            if (e.getCause() != null) {
                System.err.println("Caused by: " + e.getCause().getMessage());
            }
        }
    }
}
