package org.example.endtermapi.controller;

import org.example.endtermapi.dto.MedicineDTO;
import org.example.endtermapi.model.BaseMedicine;
import org.example.endtermapi.model.OTCMedicine;
import org.example.endtermapi.model.PrescriptionMedicine;
import org.example.endtermapi.service.interfaces.MedicineService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicines")
public class MedicineController {

    private final MedicineService service;

    public MedicineController(MedicineService service) {
        this.service = service;
    }

    @PostMapping
    public BaseMedicine createMedicine(@RequestBody MedicineDTO dto) {
        BaseMedicine medicine;
        if("OTC".equalsIgnoreCase(dto.getType())) {
            medicine = new OTCMedicine(dto.getId(), dto.getName());
        } else {
            medicine = new PrescriptionMedicine(dto.getId(), dto.getName(), true);
        }
        service.addMedicine(medicine);
        return medicine;
    }

    @GetMapping
    public List<BaseMedicine> getAll() {
        return service.getAll();
    }

    @PutMapping("/{id}")
    public void updateMedicine(
            @PathVariable int id,
            @RequestBody MedicineDTO dto
    ) {
    }

    @DeleteMapping("/{id}")
    public void deleteMedicine(@PathVariable int id) {
    }
}
