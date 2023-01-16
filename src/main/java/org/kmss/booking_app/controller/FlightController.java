package org.kmss.booking_app.controller;

import org.kmss.booking_app.entity.Flight;
import org.kmss.booking_app.service.flights.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {
    @Autowired
    private FlightService flightService;

    @GetMapping("/flights")
    public List<Flight> findAllFlights() {
        return flightService.findAllFlights();
    }

    @PutMapping("/flights")
    public void createOrUpdateFlight(@RequestBody Flight flight) {
        flightService.putFlight(flight);
    }

    @GetMapping("/flights/search")
    public List<Flight> searchFlight(@RequestParam("searchStr") String searchStr) {
        System.out.println(searchStr);
        return flightService.searchFlight(searchStr);
    }
}
