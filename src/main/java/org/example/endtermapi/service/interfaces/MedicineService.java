package org.example.endtermapi.service.interfaces;

import org.example.endtermapi.model.BaseMedicine;

import java.util.List;

public interface MedicineService {
    void addMedicine(BaseMedicine medicine);
    List<BaseMedicine> getAll();

    void delete(int id);
}
