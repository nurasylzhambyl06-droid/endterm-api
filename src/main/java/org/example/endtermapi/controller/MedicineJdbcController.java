package org.example.endtermapi.controller;

import org.example.endtermapi.cache.MedicineCache;
import org.example.endtermapi.model.Medicine;
import org.example.endtermapi.repository.JdbcMedicineRepository;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/medicines/db")
public class MedicineJdbcController {

    private final JdbcMedicineRepository repository =
            new JdbcMedicineRepository();

    @GetMapping
    public List<Medicine> getAll() throws SQLException {

        MedicineCache cache = MedicineCache.getInstance();

        if (cache.getCachedMedicines() != null) {
            System.out.println("Returning data from CACHE");
            return cache.getCachedMedicines();
        }

        System.out.println("Fetching data from DATABASE");

        List<Medicine> medicines = repository.findAll();
        cache.setCachedMedicines(medicines);

        return medicines;
    }

    @PostMapping
    public String create(@RequestBody Medicine medicine) throws SQLException {
        repository.save(medicine);
        MedicineCache.getInstance().clear();
        return "Medicine saved to database";
    }

    @PutMapping("/{id}")
    public String update(
            @PathVariable int id,
            @RequestBody Medicine medicine
    ) throws SQLException {

        repository.update(id, medicine);
        MedicineCache.getInstance().clear();
        return "Medicine updated";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) throws SQLException {
        repository.delete(id);
        MedicineCache.getInstance().clear();
        return "Medicine deleted";
    }
}
