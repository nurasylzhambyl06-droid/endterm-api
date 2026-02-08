package model;

public abstract class BaseEntity {
    protected int id;
    protected String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getInfo();
    public abstract boolean isValid();

    public String shortInfo() {
        return id + ": " + name;
    }
}
