package org.kmss.booking_app.payload.booking;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookingCustomerDetail {
    private String code;
    private String name;
    private String email;
    private String phoneNumber;
}
