package org.example.service;

import org.example.entity.Movie;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class MovieService {

    Map<Integer, Movie> movies;
    private final AtomicInteger movieIdCounter;


    public MovieService() {
        this.movies = new HashMap<>();
        this.movieIdCounter = new AtomicInteger(0);
    }

    public Movie getMovie(int movieId) throws Exception{
        if(!movies.containsKey(movieId)){
            throw new Exception("Movie with ID " + movieId + " not found");
        }
        return movies.get(movieId);
    }

    public void createMovie(String movieName, int durationInMinutes){
        int movieId = movieIdCounter.incrementAndGet();
        Movie movie = new Movie(movieId, movieName, durationInMinutes);
        movies.put(movieId, movie);
    }



}
