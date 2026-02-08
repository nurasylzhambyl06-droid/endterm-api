package model;

import model.interfaces.PricedItem;
import model.interfaces.Validatable;

public class Medicine extends BaseEntity
        implements Validatable, PricedItem {

    private double price;

    public Medicine(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String getInfo() {
        return "Medicine " + name + ", price: " + price;
    }

    @Override
    public boolean isValid() {
        return price > 0 && name != null;
    }
}

