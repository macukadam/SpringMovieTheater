package io.org.saloon;

import java.util.List;
import io.org.utils.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaloonService {
	
	@Autowired
	private SaloonRepository saloonRepository;
	
	
	public List<Saloon> getAllSaloons(){
		return Util.toList(saloonRepository.findAll());
	}

	public Saloon getSaloon(String id){
		return saloonRepository.findById(id).get();
	}
	
	public void addSaloon(Saloon saloon) {
		saloonRepository.save(saloon);
	}
	
	public void updateSaloon(Saloon saloon) {
		saloonRepository.save(saloon);
	}
	
	public void deleteSaloon(String id) {
		saloonRepository.deleteById(id);
	}
}
