package patterns.builder;

import model.Medicine;

public class MedicineBuilder {

    private int id;
    private String name;
    private double price;

    public MedicineBuilder id(int id) {
        this.id = id;
        return this;
    }

    public MedicineBuilder name(String name) {
        this.name = name;
        return this;
    }

    public MedicineBuilder price(double price) {
        this.price = price;
        return this;
    }

    public Medicine build() {
        return new Medicine(id, name, price);
    }
}
