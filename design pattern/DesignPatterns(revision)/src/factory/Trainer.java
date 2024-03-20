package factory;

public class Trainer extends Person {
    private String specialty;

    public Trainer(String name, int age, String gender,String specialty) {
        super(name, age, gender);
        this.specialty=specialty;
    }

    public Trainer(String name, int age, String gender) {
        super(name, age, gender);
    }

    public Trainer() {
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }
}
