package org.kmss.booking_app.controller;

import org.kmss.booking_app.payload.booking.BookingRequest;
import org.kmss.booking_app.payload.booking.BookingResponse;
import org.kmss.booking_app.service.bookings.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings/{code}")
    BookingResponse getBookingDetailByCode(@PathVariable String code) {
        return bookingService.findBookingByCode(code);
    }

    @PostMapping("/booking")
    BookingResponse createBooking(@RequestBody BookingRequest bookingRequest) {
        return bookingService.createBooking(bookingRequest);
    }
}
