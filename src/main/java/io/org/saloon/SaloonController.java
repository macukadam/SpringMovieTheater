package io.org.saloon;

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
public class SaloonController {

    private SaloonService saloonService;

    @Autowired
    public SaloonController(SaloonService saloonService) {
        this.saloonService = saloonService;
    }

    @GetMapping
    public List<Saloon> getAllSaloons() {
        return saloonService.getAllSaloons();
    }

    @GetMapping(value = "/{id}")
    public Saloon getSaloon(@PathVariable String id) {
        return saloonService.getSaloon(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteSaloon(@PathVariable String id) {
        saloonService.deleteSaloon(id);
    }

    @PostMapping
    public void addSaloon(@RequestBody Saloon saloon) {
        saloonService.addSaloon(saloon);
    }

    @PutMapping
    public void updateSaloon(@RequestBody Saloon saloon) {
        saloonService.updateSaloon(saloon);
    }
}
