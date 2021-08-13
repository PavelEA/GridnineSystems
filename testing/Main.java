package com.gridnine.testing;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        List<Flight> flightList = FlightBuilder.createFlights();


        Filterer filtererOne = FiltererBuilder.create(flightList)
                .addFilter(new DepartureUpToTheCurrentTime()).build();

        System.out.println(filtererOne.filter());


        Filterer filtererTwo = FiltererBuilder.create(flightList)
                .addFilter(new ArrivalBeforeDeparture()).build();

        System.out.println(filtererTwo.filter());

        Filterer filtererThree = FiltererBuilder.create(flightList)
                .addFilter(new LongTimeWait()).build();

        System.out.println(filtererThree.filter());


    }
}