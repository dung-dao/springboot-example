package org.kmss.booking_app.payload.booking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingRequest {
    private String customerCode;
    private String FlightCode;
}
