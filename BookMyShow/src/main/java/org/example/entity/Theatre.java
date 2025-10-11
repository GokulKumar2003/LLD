package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final int theatreId;
    private final String name;
    private final List<Screen> screens;
    private final String locationCity;

    public Theatre(int theatreId, String name, String locationCity) {
        this.theatreId = theatreId;
        this.name = name;
        this.screens = new ArrayList<>();
        this.locationCity = locationCity;
    }

    public int getTheatreId() {
        return theatreId;
    }

    public String getName() {
        return name;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    public String getLocationCity() {
        return locationCity;
    }

}
