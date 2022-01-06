package com.bms.model;

import com.bms.model.payment.IPaymentMode;

import java.util.List;

public class Booking extends DBObject {
    int numberOfSeats;
    List<ShowSeat> seats;
    BookingStatus bookingStatus;
    Show show;
    IPaymentMode paymentMode;
}
