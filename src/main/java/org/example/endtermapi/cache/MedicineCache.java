package org.example.endtermapi.cache;

import org.example.endtermapi.model.Medicine;

import java.util.List;

public class MedicineCache {

    private static MedicineCache instance;

    private List<Medicine> cachedMedicines;

    private MedicineCache() {}

    public static MedicineCache getInstance() {
        if (instance == null) {
            instance = new MedicineCache();
        }
        return instance;
    }

    public List<Medicine> getCachedMedicines() {
        return cachedMedicines;
    }

    public void setCachedMedicines(List<Medicine> medicines) {
        this.cachedMedicines = medicines;
    }

    public void clear() {
        cachedMedicines = null;
    }
}
