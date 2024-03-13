package test;

public class Student extends Person{
    public Student(String name, int age, String course) {
        super(name, age);
        this.course = course;
    }

    public Student() {
    }

    private String course;

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void learn(){
        System.out.println("learning");
    }
}
