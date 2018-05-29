package io.org.movie;

import io.org.saloon.SaloonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/saloons")
public class MovieController {

    private MovieService movieService;
    private SaloonService saloonService;

    @Autowired
    public MovieController(MovieService movieService, SaloonService saloonService) {
        this.movieService = movieService;
        this.saloonService = saloonService;
    }

    @GetMapping(value = "/{saloonid}/movies")
    public List<Movie> getAllMovies(@PathVariable String saloonid) {
        return movieService.getAllMovies(saloonid);
    }

    @GetMapping(value = "/{salonid}/movies/{id}")
    public Movie getMovie(@PathVariable String id) {
        return movieService.getMovie(id);
    }

    @PostMapping(value = "/{saloonid}/movies")
    public void addMovie(@RequestBody Movie movie, @PathVariable String saloonid) {
        movie.setSaloons(saloonService.getSaloon(saloonid));
        movieService.saveMovie(movie);
    }

    @PutMapping(value = "/{saloonid}/movies")
    public void updateMovie(@RequestBody Movie movie, @PathVariable String saloonid) {
        movie.setSaloons(saloonService.getSaloon(saloonid));
        movieService.saveMovie(movie);
    }

    @DeleteMapping(value = "/{saloonid}/movies/{id}")
    public void deleteMovie(@RequestBody Movie movie) {
        movieService.deleteMovie(movie);
    }

}
