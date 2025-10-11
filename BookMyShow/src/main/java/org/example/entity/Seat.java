package org.example.entity;

import org.example.enums.SeatCategory;

public class Seat {

    private final int seatId;
    private final int row;
    private final int col;
    private final SeatCategory seatCategory;

    public Seat(int seatId, int row, int col, SeatCategory seatCategory) {
        this.seatId = seatId;
        this.row = row;
        this.col = col;
        this.seatCategory = seatCategory;
    }

    public int getSeatId() {
        return seatId;
    }

    public int getRow() {
        return row;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public int getCol() {
        return col;
    }
}
