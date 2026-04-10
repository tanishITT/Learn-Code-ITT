package com.assignment.domain;

import java.util.List;

public interface GeocodingProvider {
    List<Location> geocode(String address) throws GeocodingException;
}
