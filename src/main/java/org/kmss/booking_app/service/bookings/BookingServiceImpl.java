package org.kmss.booking_app.service.bookings;

import org.kmss.booking_app.repository.BookingRepository;
import org.kmss.booking_app.repository.CustomerRepository;
import org.kmss.booking_app.repository.FlightRepository;
import org.kmss.booking_app.entity.Booking;
import org.kmss.booking_app.entity.Customer;
import org.kmss.booking_app.entity.Flight;
import org.kmss.booking_app.exception.ResourceNotFoundException;
import org.kmss.booking_app.payload.booking.BookingCustomerDetail;
import org.kmss.booking_app.payload.booking.BookingDetail;
import org.kmss.booking_app.payload.booking.BookingFlightDetail;
import org.kmss.booking_app.payload.booking.BookingRequest;
import org.kmss.booking_app.payload.booking.BookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public BookingResponse createBooking(BookingRequest bookingRequest) throws ResourceNotFoundException {
        var customerCode = bookingRequest.getCustomerCode();
        var flightCode = bookingRequest.getFlightCode();

        var optionalCustomer = customerRepository.findCustomerByCode(customerCode);
        var optionalFlight = flightRepository.findFlightByCode(flightCode);

        if (optionalCustomer.isEmpty() || optionalFlight.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var uuidStr = UUID.randomUUID().toString();
        var bookingBuilder = Booking.builder()
                .code(uuidStr)
                .customerCode(customerCode)
                .flightCode(flightCode);
        var booking = bookingBuilder.build();
        bookingRepository.save(booking);

        // Send booking response
        var customer = optionalCustomer.get();
        var flight = optionalFlight.get();

        return createBookingResponse(booking, customer, flight);
    }

    private BookingResponse createBookingResponse(Booking booking, Customer customer, Flight flight) {
        var customerDetail = BookingCustomerDetail.builder()
                .code(customer.getCode())
                .name(customer.getName())
                .email(customer.getEmail())
                .phoneNumber(customer.getPhoneNumber())
                .build();
        var flightDetail = BookingFlightDetail.builder()
                .code(flight.getCode())
                .date(flight.getDate())
                .origin(flight.getOrigin())
                .destination(flight.getDestination())
                .name(flight.getName())
                .build();
        var bookingDetail = BookingDetail.builder()
                .id(booking.getId())
                .code(booking.getCode())
                .customerCode(booking.getCustomerCode())
                .flightCode(booking.getFlightCode())
                .createdAt(booking.getCreatedAt())
                .customerDetail(customerDetail)
                .flightDetail(flightDetail)
                .build();
        return new BookingResponse(bookingDetail);
    }

    @Override
    public BookingResponse findBookingByCode(String code) throws ResourceNotFoundException {
        var result = bookingRepository.findBookingDetailByCode(code);
        if (result.isEmpty()) {
            throw new ResourceNotFoundException();
        }

        var bookingData = result.get(0);
        var customer = (Customer) bookingData[0];
        var flight = (Flight) bookingData[1];
        var booking = (Booking) bookingData[2];

        if (customer == null || flight == null) {
            throw new ResourceNotFoundException();
        }

        return createBookingResponse(booking, customer, flight);
    }
}
