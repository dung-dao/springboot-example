package org.kmss.booking_app.payload.booking;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {
    private BookingDetail bookingDetail;
}
