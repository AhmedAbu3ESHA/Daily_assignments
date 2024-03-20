package factory;

public class Factory {

    public static Person getPerson(String type){
        if (type.equals("trainer"))
            return new Trainer();
        else if (type.equals("student"))
            return new Student();

        return null;
    }
}
