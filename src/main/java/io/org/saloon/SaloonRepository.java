package io.org.saloon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaloonRepository extends CrudRepository<Saloon, String> {

}
