package model;

public class Patient extends BaseEntity {

    private String phone;

    public Patient(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String getInfo() {
        return "Patient " + name + ", phone: " + phone;
    }

    @Override
    public boolean isValid() {
        return name != null && !name.isEmpty();
    }
}

