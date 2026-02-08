package patterns.factory;

import model.BaseMedicine;
import model.OTCMedicine;
import model.PrescriptionMedicine;

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
