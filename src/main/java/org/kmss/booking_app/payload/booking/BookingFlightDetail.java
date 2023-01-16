package org.kmss.booking_app.payload.booking;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingFlightDetail {
    private String code;
    private String name;
    private String origin;
    private String destination;
    private Date date;
}
