package controller;

import model.BaseMedicine;
import service.interfaces.MedicineService;
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
    public void createMedicine(@RequestBody BaseMedicine medicine) {
        service.addMedicine(medicine);
    }

    @GetMapping
    public List<BaseMedicine> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
