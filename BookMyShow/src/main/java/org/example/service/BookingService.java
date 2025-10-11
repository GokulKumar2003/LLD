package org.example.service;

import org.example.entity.Booking;
import org.example.entity.Seat;
import org.example.entity.Show;
import org.example.entity.User;
import org.example.lock.SeatLockInterfaceProvider;

import java.lang.classfile.AttributeMapper;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BookingService {

    private final Map<Integer, Booking> bookings;
    private final SeatLockInterfaceProvider seatLockProvider;
    private final AtomicInteger bookingIdCounter;

    public BookingService(SeatLockInterfaceProvider seatLockProvider){
        this.seatLockProvider = seatLockProvider;
        this.bookings = new HashMap<>();
        this.bookingIdCounter = new AtomicInteger();
    }

    public Booking createBooking(final User user, Show show,
                                 final List<Seat> seats) throws Exception{

        if(isAnySeatAlreadyBooked(show, seats)){
            throw new Exception("Seat is already booked");
        }

        seatLockProvider.lockSeats(show, seats, user);
        final Integer bookingId = bookingIdCounter.incrementAndGet();
        final Booking booking = new Booking(bookingId, user, show, seats);

        bookings.put(bookingId, booking);
        return booking;
    }

    public List<Booking> getAllBookings(final Show show){
        List<Booking> bookingList = new ArrayList<>();
        for(Booking booking : bookings.values()){
            if(booking.getShow().equals(show)){
                bookingList.add(booking);
            }
        }
        return bookingList;
    }

    public List<Seat> getBookedSeats(final Show show){
        return getAllBookings(show).stream()
                .filter(Booking::isBookingConfirmed)
                .map(booking -> booking.getSeats())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }

    public boolean isAnySeatAlreadyBooked(Show show, List<Seat> seats){
        final List<Seat> bookedSeats = getBookedSeats(show);
        for(Seat seat : seats){
            if (bookedSeats.contains(seat)){
                return true;
            }
        }
        return false;
    }
}
