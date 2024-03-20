package factory;

public class Main {
    public static void main(String[] args) {

        Person p=Factory.getPerson("student");
        if (p instanceof Trainer) {
            Trainer t = (Trainer) p;
        }else if (p instanceof Student){
            Student s= (Student) p;
        }




    }
}
