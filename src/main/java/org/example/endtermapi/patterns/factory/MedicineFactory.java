package org.example.endtermapi.patterns.factory;

import org.example.endtermapi.model.BaseMedicine;
import org.example.endtermapi.model.OTCMedicine;
import org.example.endtermapi.model.PrescriptionMedicine;

public class MedicineFactory {

    public static BaseMedicine create(int id, String name, String type) {
        if ("OTC".equalsIgnoreCase(type)) {
            return new OTCMedicine(id, name);
        }
        if ("PRESCRIPTION".equalsIgnoreCase(type)) {
            return new PrescriptionMedicine(id, name, true);
        }
        throw new IllegalArgumentException("Unknown medicine type");
    }
}
