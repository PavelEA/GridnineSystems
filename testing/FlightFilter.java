package com.gridnine.testing;
import com.gridnine.testing.Flight;

import java.time.LocalDateTime;
import java.util.List;


public interface FlightFilter {
    List<Flight> filter(List<Flight> flightList);
}