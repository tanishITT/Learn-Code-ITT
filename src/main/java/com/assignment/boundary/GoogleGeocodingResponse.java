package com.assignment.boundary;

import com.google.gson.annotations.SerializedName;

import java.util.List<Result>;

public record GoogleGeocodingResponse(
        List<Result> results,
        String status,
        @SerializedName("error_message") String errorMessage
) {
    public record Result(
            @SerializedName("formatted_address") String formattedAddress,
            Geometry geometry
    ) {}

    public record Geometry(LocationPoint location) {}

    public record LocationPoint(double lat, double lng) {}
}
