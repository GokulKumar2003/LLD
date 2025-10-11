package org.example.entity;

public class Movie {

    private final int movieId;
    private final String movieName;
    private final int duration; // in mins

    public Movie(int movieId, String movieName, int duration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.duration = duration;
    }

    public int getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getDuration() {
        return duration;
    }
}
