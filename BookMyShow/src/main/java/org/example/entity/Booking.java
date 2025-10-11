package org.example.entity;

import org.example.enums.BookingStatus;

import java.util.List;

public class Booking {

    private final int bookingId;
    private final User user;
    private final Show show;
    private final List<Seat> seats;
    private final BookingStatus bookingStatus;

    public Booking(int bookingId, User user, Show show, List<Seat> seats) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.seats = seats;
        this.bookingStatus = BookingStatus.CREATED;
    }

    public int getBookingId() {
        return bookingId;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public boolean isBookingConfirmed(){
        return this.bookingStatus == BookingStatus.CONFIRMED;
    }
}
