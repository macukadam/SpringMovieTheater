package io.org.saloon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaloonService {

    private SaloonRepository saloonRepository;

    @Autowired
    public SaloonService(SaloonRepository saloonRepository) {
        this.saloonRepository = saloonRepository;
    }

    public List<Saloon> getAllSaloons() {
        List<Saloon> saloonList = new ArrayList<>();
        saloonRepository.findAll().forEach(saloon -> saloonList.add(saloon));
        return saloonList;
    }

    public Saloon getSaloon(String id) {
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
