package test;

public class Trainer extends Person{
    public Trainer(String name, int age, String specialty) {
        super(name, age);
        this.specialty = specialty;
    }

    public Trainer() {
    }

    private String specialty;

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public void teach(){
        System.out.println("teaching");
    }
}
