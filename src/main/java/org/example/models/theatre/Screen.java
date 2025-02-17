package org.example.models.theatre;

import org.example.models.theatre.Seat;

import java.util.ArrayList;
import java.util.List;

public class Screen {

    int screenId;
    List<Seat> seats = new ArrayList<>();

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
