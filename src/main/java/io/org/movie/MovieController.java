package io.org.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.org.saloon.Saloon;
import io.org.saloon.SaloonService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private SaloonService saloonService;
	
	@RequestMapping(value="/saloons/{saloonid}/movies", method = RequestMethod.GET)
	public List<Movie> getAllMovies(@PathVariable String saloonid){
		return movieService.getAllMovies(saloonid);
	}
	
	@RequestMapping(value="/saloons/{salonid}/movies/{id}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable String id) {
		return movieService.getMovie(id);
	}
	
	@RequestMapping(value="saloons/{saloonid}/movies", method = RequestMethod.POST)
	public void addMovie(@RequestBody Movie movie, @PathVariable String saloonid) {
		movie.setSaloons(saloonService.getSaloon(saloonid));
		movieService.saveMovie(movie);
	}
	
	@RequestMapping(value="saloons/{saloonid}/movies", method = RequestMethod.PUT)
	public void updateMovie(@RequestBody Movie movie, @PathVariable String saloonid) {
		movie.setSaloons(saloonService.getSaloon(saloonid));
		movieService.saveMovie(movie);
	}
	
	@RequestMapping(value="saloons/{saloonid}/movies/{id}", method = RequestMethod.DELETE)
	public void deleteMovie(@RequestBody Movie movie) {
		movieService.deleteMovie(movie);
	}
	
}
