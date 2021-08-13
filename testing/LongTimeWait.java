package com.gridnine.testing;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class LongTimeWait implements FlightFilter {

    private static final int TIME_WAITING = 2;

    @Override
    public List<Flight> filter(List<Flight> flightList) {
        return flightList
                .stream()
                .filter(flight -> flight.getSegments().size() > 1)
                .filter(flight -> longerThenTW(flight.getSegments()))
                .collect(Collectors.toList());
    }

    private boolean longerThenTW(List<Segment> segments) {
        long totalTime = 0;
        for (int j = 1; j < segments.size(); j++) {
            totalTime += Duration.between(segments.get(j - 1).getArrivalDate(),
                    segments.get(j).getDepartureDate()).toHours();
        }
        return totalTime > TIME_WAITING;
    }
}

