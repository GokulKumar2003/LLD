package org.example.service;

import org.example.entity.Seat;
import org.example.entity.Show;
import org.example.lock.SeatLockInterfaceProvider;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class SeatAvailabilityService {

    private final BookingService bookingService;

    private final SeatLockInterfaceProvider seatLockProvider;

    public SeatAvailabilityService(final BookingService bookingService,
                                   final SeatLockInterfaceProvider seatLockProvider){

        this.bookingService = bookingService;
        this.seatLockProvider = seatLockProvider;
    }

    public List<Seat> getAvailableSeats(final Show show){

        final List<Seat> allSeats = show.getScreen().getSeats();

        final List<Seat> bookedSeats = bookingService.getBookedSeats(show);
        final List<Seat> lockedSeats = seatLockProvider.getLockedSeats(show);

        final List<Seat> availableSeats = new ArrayList<>(allSeats);
        availableSeats.removeAll(bookedSeats);
        availableSeats.removeAll(lockedSeats);
        return availableSeats;
    }


}
