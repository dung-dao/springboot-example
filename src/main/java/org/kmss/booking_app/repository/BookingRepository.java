package org.kmss.booking_app.repository;

import java.util.List;

import org.kmss.booking_app.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {
    @Query(value = "select c, f, b "
            + "from Booking b, Customer c, Flight f "
            + "where b.code = ?1 and b.customerCode = c.code and b.flightCode = f.code")
    List<Object[]> findBookingDetailByCode(String code);
}
