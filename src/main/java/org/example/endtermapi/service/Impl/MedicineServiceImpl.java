package org.example.endtermapi.service.Impl;

import org.example.endtermapi.model.BaseMedicine;
import org.example.endtermapi.repository.InMemoryMedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.endtermapi.repository.interfaces.CrudRepository;
import org.example.endtermapi.service.interfaces.MedicineService;

import java.util.List;

@Service
public class MedicineServiceImpl implements MedicineService {
    private final CrudRepository<BaseMedicine> repository;

    @Autowired
    public MedicineServiceImpl(InMemoryMedicineRepository repository) {
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
        repository.delete(id);
    }
}
