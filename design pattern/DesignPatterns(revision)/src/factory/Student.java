package factory;

public class Student extends Person {
    private String course;

    public Student(String name, int age, String gender,String course) {
        super(name, age, gender);
        this.course = course;
    }

    public Student(String name, int age, String gender) {
        super(name, age, gender);
    }

    public Student() {
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }
}
