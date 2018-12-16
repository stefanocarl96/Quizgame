package tech.bts.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import tech.bts.Service.Movie;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/movies")
public class MovieWebController {

    private Movie Movie;

    @Autowired
    public MovieWebController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String getMovies() throws IOException{
        Map<String, Object> values = new HashMap<>();
        values.put("movies", movieService.getAllMovies());
        return HandlebarsUtil.getTemplate("movies-list", values);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{movieTitle}")
    public String getMovieByTitle(@PathVariable String movieTitle) throws IOException{
        Movie movie = movieService.getMovieByTitle(movieTitle);
        Map<String, Object> values = new HashMap<>();
        values.put("movie", movie);
        return HandlebarsUtil.getTemplate("movie-detail", values);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public void addMovie(HttpServletResponse response, Movie movie) throws IOException {
        movieService.addMovie(movie);
        response.sendRedirect("/movies");
    }
}
