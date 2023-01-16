package org.kmss.booking_app.repository;

import org.kmss.booking_app.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight, String> {
    Optional<Flight> findFlightByCode(String code);

    @Query("select f " +
            "from Flight f " +
            "where lower(f.code) like lower(concat('%', ?1,'%')) OR " +
            "lower(f.name) like lower(concat('%', ?1,'%')) OR " +
            "lower(f.origin) like lower(concat('%', ?1,'%')) OR " +
            "lower(f.destination) like lower(concat('%', ?1,'%')) OR " +
            "lower(?1) like concat('%', day(f.date), '/', month(f.date), '/', year(f.date) ,'%')")
    public List<Flight> searchFlights(String searchStr);
}
