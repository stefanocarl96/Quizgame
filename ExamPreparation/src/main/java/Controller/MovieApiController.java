package tech.bts.Controller;


import org.springframework.beans.factory.annotation.Autowired;

import tech.bts.Service.MovieService;

import java.util.List;

@RestController
@RequestMapping(path = "/api/movies")
public class MovieApiController {

    private Movie Movie;

    @Autowired
    public MovieApiController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> getMovies(){
        return movieService.getAllMovies();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addMovie(@RequestBody Movie movie) {
        this.movieService.addMovie(movie);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{movieTitle}")
    public Movie getMovie(@PathVariable String movieTitle) {
        return this.movieService.getMovieByTitle(movieTitle);
    }
}
