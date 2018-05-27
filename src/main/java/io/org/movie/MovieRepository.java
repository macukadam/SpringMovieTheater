package io.org.movie;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, String>{
	public List<Movie> findBySaloonId(String saloonId);
}
