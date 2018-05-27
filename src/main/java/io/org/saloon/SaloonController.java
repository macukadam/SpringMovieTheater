package io.org.saloon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaloonController {

	@Autowired
	public SaloonService saloonService;
	
	@RequestMapping(value="/saloons", method= RequestMethod.GET)
	public List<Saloon> getAllSaloons(){
		return saloonService.getAllSaloons();
	}
	
	@RequestMapping(value="/saloons/{id}", method= RequestMethod.GET)
	public Saloon getSaloon(@PathVariable String id) {
		return saloonService.getSaloon(id);
	}
	
	@RequestMapping(value="/saloons/{id}", method= RequestMethod.DELETE)
	public void deleteSaloon(@PathVariable String id) {
		saloonService.deleteSaloon(id);
	}
	
	@RequestMapping(value="/saloons", method= RequestMethod.POST)
	public void addSaloon(@RequestBody Saloon saloon) {
		saloonService.addSaloon(saloon);
	}
	
	@RequestMapping(value="/saloons", method= RequestMethod.PUT)
	public void updateSaloon(@RequestBody Saloon saloon) {
		saloonService.updateSaloon(saloon);
	}
}
