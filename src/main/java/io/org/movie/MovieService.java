package io.org.movie;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	public Movie getMovie(String id) {
		return movieRepository.findById(id).get();
	}
	
	public Movie saveMovie(Movie movie) {
		return movieRepository.save(movie);
	}
	
	public void deleteMovie(Movie movie) {
		movieRepository.delete(movie);
	}
	
	public List<Movie> getAllMovies(String saloonId) {
		return movieRepository.findBySaloonId(saloonId);
	}
}
