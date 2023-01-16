package org.kmss.booking_app.service.bookings;

import org.kmss.booking_app.exception.ResourceNotFoundException;
import org.kmss.booking_app.payload.booking.BookingRequest;
import org.kmss.booking_app.payload.booking.BookingResponse;

public interface BookingService {
    BookingResponse createBooking(BookingRequest bookingRequest) throws ResourceNotFoundException;
    BookingResponse findBookingByCode(String code) throws ResourceNotFoundException;
}
