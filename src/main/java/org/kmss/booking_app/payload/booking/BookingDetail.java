package org.kmss.booking_app.payload.booking;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingDetail {
    private Long id;
    private String code;
    private String customerCode;
    private String flightCode;
    private Date createdAt;

    private BookingCustomerDetail customerDetail;
    private BookingFlightDetail flightDetail;
}
