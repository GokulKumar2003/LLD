package org.example.entity;

import java.time.LocalDate;

public class Show {

    private final int showId;
    private final Movie movie;
    private final Screen screen;
    private final LocalDate startTime;
    private final int duration;

    public Show(int showId, Movie movie, Screen screen, LocalDate startTime, int duration) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.startTime = startTime;
        this.duration = duration;
    }

    public int getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public int getDuration() {
        return duration;
    }
}
