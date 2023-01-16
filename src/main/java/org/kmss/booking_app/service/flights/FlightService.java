package org.kmss.booking_app.service.flights;

import java.util.List;

import org.kmss.booking_app.entity.Flight;

public interface FlightService {
    List<Flight> findAllFlights();

    void putFlight(Flight flight);

    List<Flight> searchFlight(String searchStr);
}
