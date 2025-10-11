package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    private final int screenId;
    private final String name;
    private final Theatre theatre;
    private final List<Seat> seats;

    public Screen(final int id, final String name, final Theatre theatre) {
        this.screenId = id;
        this.name = name;
        this.theatre = theatre;
        this.seats = new ArrayList<>();
    }

    public int getScreenId() {
        return screenId;
    }

    public String getName() {
        return name;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}
