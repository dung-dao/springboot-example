package org.kmss.booking_app.service.flights;

import org.kmss.booking_app.entity.Flight;
import org.kmss.booking_app.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightRepository flightRepository;

    @Override
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public void putFlight(Flight flight) {
        var flightBuilder = flight.toBuilder();
        if (flight.getCode() == null) {
            var uuidAsString = UUID.randomUUID().toString();
            flightBuilder.code(uuidAsString);
        }

        flightRepository.save(flightBuilder.build());
    }

    @Override
    public List<Flight> searchFlight(String searchStr) {
        return flightRepository.searchFlights(searchStr);
    }
}
