package test;

public class Factory {

    public static Person getPerson(String type){
        if (type.equals("student")) return new Student();
        else if (type.equals("trainer")) return new Trainer();
        else return new Person();
    }
}
