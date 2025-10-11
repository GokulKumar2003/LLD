package org.example.service;

import org.example.entity.Screen;
import org.example.entity.Seat;
import org.example.entity.Theatre;
import org.example.enums.SeatCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class TheatreService {

    private final Map<Integer, Theatre> theatres;
    private final Map<Integer, Screen> screens;
    private final Map<Integer, Seat> seats;
    private final Map<String, List<Integer>> theatresInALocation;

    private final AtomicInteger theatreCounter;
    private final AtomicInteger screenCounter;
    private final AtomicInteger seatCounter;

    public TheatreService(){
        this.theatres = new HashMap<>();
        this.screens = new HashMap<>();
        this.seats = new HashMap<>();
        this.theatresInALocation = new HashMap<>();
        theatreCounter = new AtomicInteger();
        screenCounter = new AtomicInteger();
        seatCounter = new AtomicInteger();

    }

    public Theatre getTheatre(int theatreId) throws Exception{

        if(!theatres.containsKey(theatreId)){
            throw new Exception("Theatre with ID " + theatreId + " no found");
        }
        return theatres.get(theatreId);
    }

    public Seat getSeat(int seatId) throws Exception{
        if(!seats.containsKey(seatId)){
            throw new Exception("Seat not found");
        }
        return seats.get(seatId);
    }

    public Screen getScreen(int screenId) throws Exception{
        if(!screens.containsKey(screenId)){
            throw new Exception("Seat not found");
        }
        return screens.get(screenId);
    }

    public Theatre createTheatre(String theatreName, String locationCity){
        int theatreId = theatreCounter.incrementAndGet();
        Theatre theatre = new Theatre(theatreId, theatreName, locationCity);
        theatres.put(theatreId, theatre);
        List<Integer> theatreIdList =
                theatresInALocation.computeIfAbsent(locationCity,
                        k -> new ArrayList<>());
        theatreIdList.add(theatreId);
        return theatre;
    }

    public Screen createScreenInTheatre(final String screenName,
                                        final Integer theatreId) throws Exception{
        if(!theatres.containsKey(theatreId)){
            throw new Exception("Theatre is not found");
        }
        Integer screenId = screenCounter.incrementAndGet();
        Theatre theatre = theatres.get(theatreId);
        Screen screen = new Screen(screenId, screenName,
                theatre);
        screens.put(screenId, screen);
        theatre.getScreens().add(screen);
        return screen;
    }

    public Seat createSeatInScreen(final Integer row,
                              Integer col, SeatCategory seatCategory,
                              final Integer screenId) throws Exception{
        if(!screens.containsKey(screenId)){
            throw new Exception("Screen is not found");
        }
        Integer seatId = seatCounter.incrementAndGet();
        Screen screen = screens.get(screenId);
        Seat seat = new Seat(seatId, row, col, seatCategory);
        seats.put(seatId, seat);
        screen.getSeats().add(seat);
        return seat;
    }

}
