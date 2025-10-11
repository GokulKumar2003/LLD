package org.example.service;

import org.example.entity.Movie;
import org.example.entity.Screen;
import org.example.entity.Show;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ShowService {

    private final Map<Integer, Show> shows;
    private final AtomicInteger showCounter;

    public ShowService(){
        this.shows = new HashMap<>();
        showCounter = new AtomicInteger();
    }

    public Show createShow(final Movie movie, final Screen screen,
                           final LocalDate startTime, final int duration){

        int showId = showCounter.incrementAndGet();
        Show show = new Show(showId, movie, screen, startTime, duration);
        shows.put(showId, show);
        return show;
    }

    public List<Show> getShowsForScreen(final Screen screen){
        final List<Show> showList = new ArrayList<>();
        for(Show show : shows.values()){
            if(show.getScreen().getScreenId() == screen.getScreenId()){
                showList.add(show);
            }
        }
        return showList;
    }
}
