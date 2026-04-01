package com.skyscanner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HoenScannerApplication extends Application<HoenScannerConfiguration> {

    private final List<SearchResult> searchResults = new ArrayList<>();

    public static void main(final String[] args) throws Exception {
        new HoenScannerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hoen-scanner";
    }

    @Override
    public void initialize(final Bootstrap<HoenScannerConfiguration> bootstrap) {
        // nothing here for now
    }

    @Override
    public void run(final HoenScannerConfiguration configuration, final Environment environment) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Load rental cars
        List<SearchResult> cars = mapper.readValue(
                new File("src/main/resources/rental_cars.json"),
                new TypeReference<List<SearchResult>>() {}
        );

        // Load hotels
        List<SearchResult> hotels = mapper.readValue(
                new File("src/main/resources/hotels.json"),
                new TypeReference<List<SearchResult>>() {}
        );

        searchResults.addAll(cars);
        searchResults.addAll(hotels);

        // Register resource
        environment.jersey().register(new SearchResource(searchResults));
    }
}