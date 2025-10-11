package org.example.lock;

import org.example.entity.Seat;
import org.example.entity.Show;
import org.example.entity.User;

import javax.crypto.CipherInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SeatLockInterfaceProvider implements SeatLockInterface{

    private final Integer lockTimeout;
    private final Map<Show, Map<Seat, SeatLock>> locks;

    public SeatLockInterfaceProvider(Integer lockTimeout) {
        this.lockTimeout = lockTimeout;
        this.locks = new ConcurrentHashMap<>();
    }

    @Override
    public void lockSeats(Show show, List<Seat> seats, User user) throws Exception {
        Map<Seat, SeatLock> seatLocks = locks.computeIfAbsent(show,
                s -> new ConcurrentHashMap<>());

        // check if all seats are not locked already
        synchronized (seatLocks) {
            for (Seat seat : seats) {
                if (seatLocks.containsKey(seat)) {
                    SeatLock seatLock = seatLocks.get(seat);
                    if (!seatLock.isLockExpired()) {
                        throw new Exception(STR."Seat \{seat.getSeatId()} is locked by other user");
                    }
                }
            }

            // all seats are available, lock them
            Date now = new Date();
            for (Seat seat : seats) {
                SeatLock seatLock = new SeatLock(seat, show, lockTimeout, now,
                        user);
                seatLocks.put(seat, seatLock);
            }
        }

    }

    @Override
    public void unlockSeats(Show show, List<Seat> seats, User user) {

        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if(seatLocks == null){
            return;
        }

        synchronized (seatLocks){
            for(Seat seat : seats){
                SeatLock seatLock = seatLocks.get(seat);
                if(seatLock != null && seatLock.getLockedBy().equals(user)){
                    seatLocks.remove(seat);
                }
            }
        }

    }

    @Override
    public boolean validateLock(Show show, Seat seat, User user) {

        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if(seatLocks == null){
            return false;
        }

        synchronized (seatLocks){
            SeatLock seatLock = seatLocks.get(seat);
            return seatLock != null && !seatLock.isLockExpired() && seatLock.getLockedBy().equals(user);
        }
    }

    @Override
    public List<Seat> getLockedSeats(Show show) {

        Map<Seat, SeatLock> seatLocks = locks.get(show);
        if(seatLocks == null){
            return new ArrayList<>();
        }

        synchronized (seatLocks){
            return seatLocks.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().isLockExpired())
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }
    }
}
