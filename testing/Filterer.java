package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;


class FiltererBuilder {
    private List<Flight> flights;
    private List<FlightFilter> filters = new ArrayList<>();

    private FiltererBuilder(List<Flight> flights) {
        this.flights = flights;
    }

    public static FiltererBuilder create(List<Flight> flights) {
        return new FiltererBuilder(flights);
    }

    public FiltererBuilder addFilter(FlightFilter filter) {
        filters.add(filter);
        return this;
    }

    public Filterer build() {
        return new Filterer(flights, filters);
    }
}


class Filterer {
    private List<Flight> flights;
    private List<FlightFilter> filters;

    Filterer(List<Flight> flights, List<FlightFilter> filters) {
        this.flights = flights;
        this.filters = filters;
    }


    public List<Flight> filter() {
        List<Flight> resultFlights = flights;
        for (FlightFilter filter : filters) {
            resultFlights = filter.filter(resultFlights);
        }
        return resultFlights;
    }
}