package org.example.controllers;
import org.example.enums.*;
import org.example.models.movies.Movie;
import org.example.models.theatre.Show;
import org.example.models.theatre.Theatre;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreController {

    Map<City, List<Theatre>> cityVsTheatre;
    // Nagpur → [PVR, INOX]
    // Mumbai → [Cinepolis, Carnival]

    List<Theatre> allTheatre;
    //allTheatre = [PVR, INOX, Cinepolis, Carnival]

    public TheatreController() {
        cityVsTheatre = new HashMap<>();
        allTheatre = new ArrayList<>();
    }

    public void addTheatre(Theatre theatre, City city) {

        allTheatre.add(theatre);

        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }


    public Map<Theatre, List<Show>> getAllShow(Movie movie, City city) {

        //get all the theater of this city

        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();

        List<Theatre> theatres = cityVsTheatre.get(city);
        // theatre = [PVR, INOX]

        //filter the theatres which run this movie

        for(Theatre theatre : theatres) {

            List<Show> givenMovieShows = new ArrayList<>();
            List<Show> shows = theatre.getShows();
            // shows = [morning, evening]

            for(Show show : shows) {
                if(show.getMovie().getMovieId() == movie.getMovieId()) {
                    givenMovieShows.add(show);
                }
            }
            // givenMovieShows = [morning, evening]
            if(!givenMovieShows.isEmpty()) {
                theatreVsShows.put(theatre, givenMovieShows);
            }
        }

        return theatreVsShows;
    }
}
// getAllShow("Inception", City.NAGPUR);
// theatreVsShows = { PVR → [Morning Show, Evening Show] }





//Cinepolis → [Morning Show, Evening Show]
//Carnival → [Afternoon Show]