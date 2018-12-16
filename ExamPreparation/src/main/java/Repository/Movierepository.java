package tech.bts.repository;

import org.springframework.stereotype.Repository;
import tech.bts.Model.Movie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class Movierepository {

    private Map<String, Movie> movieMap;

    public Movierepository() {
        this.movieMap = new HashMap<>();
    }

    public Movie getMovieByTitle(String title) {
        return movieMap.get(title);
    }

    public void addMovie(Movie movie) {
        movieMap.put(movie.getTitle(), movie);
    }
}