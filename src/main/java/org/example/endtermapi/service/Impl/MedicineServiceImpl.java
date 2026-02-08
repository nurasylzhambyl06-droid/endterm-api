package org.example.endtermapi.service;

import model.BaseMedicine;
import org.springframework.stereotype.Service;
import repository.interfaces.CrudRepository;
import org.example.endtermapi.service.interfaces.MedicineService;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {

    private CrudRepository<BaseMedicine> repository;

    public MedicineServiceImpl(CrudRepository<BaseMedicine> repository) {
        this.repository = repository;
    }

    @Override
    public void addMedicine(BaseMedicine medicine) {
        repository.save(medicine);
    }

    @Override
    public List<BaseMedicine> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(int id) {

    }
}
