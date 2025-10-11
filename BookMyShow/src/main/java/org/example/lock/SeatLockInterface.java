package org.example.lock;

import org.example.entity.Seat;
import org.example.entity.Show;
import org.example.entity.User;

import java.util.List;

public interface SeatLockInterface {

    void lockSeats(Show show, List<Seat> seats, User user) throws  Exception;
    void unlockSeats(Show show, List<Seat> seats, User user);
    boolean validateLock(Show show, Seat seat, User user);
    List<Seat> getLockedSeats(Show show);
}
