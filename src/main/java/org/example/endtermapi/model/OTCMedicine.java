package org.example.endtermapi.model;

import org.example.endtermapi.service.Impl.MedicineServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class OTCMedicine extends BaseMedicine {

    public OTCMedicine(int id, String name) {
        super(id, name);
    }

    @PostMapping
    public void createMedicine(@RequestBody OTCMedicine medicine) {
        MedicineServiceImpl service = null;
        service.addMedicine(medicine);
    }

    @Override
    public double calculateFinalPrice() {
        return 800.0;
    }

    @Override
    public String getType() {
        return "OTC";
    }
}
