package org.example.endtermapi.controller;

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
    public List<Medicine> getAllFromDatabase() throws SQLException {
        return repository.findAll();
    }
}
