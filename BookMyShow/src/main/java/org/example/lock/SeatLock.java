package org.example.lock;

import org.example.entity.Seat;
import org.example.entity.Show;
import org.example.entity.User;

import java.time.Instant;
import java.util.Date;

public class SeatLock {

    private Seat seat;
    private Show show;
    private Integer timeoutSecs;
    private Date lockTime;
    private User lockedBy;

    public SeatLock(Seat seat, Show show, Integer timeoutSecs, Date lockTime, User lockedBy) {
        this.seat = seat;
        this.show = show;
        this.timeoutSecs = timeoutSecs;
        this.lockTime = lockTime;
        this.lockedBy = lockedBy;
    }

    public Boolean isLockExpired(){
        Instant lockInstant = lockTime.toInstant().plusSeconds(timeoutSecs);
        Instant current = new Date().toInstant();

        return current.isAfter(lockInstant);
    }

    public Seat getSeat() {
        return seat;
    }

    public Show getShow() {
        return show;
    }

    public Integer getTimeoutSecs() {
        return timeoutSecs;
    }

    public Date getLockTime() {
        return lockTime;
    }

    public User getLockedBy() {
        return lockedBy;
    }
}
