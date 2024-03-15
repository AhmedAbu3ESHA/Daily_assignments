package singleton;

import java.util.concurrent.locks.ReentrantLock;

public class Person {
    private String name;
    private int age;

    private String gender;

    private static Person instance;//lazy initialization

    private static ReentrantLock lock=new ReentrantLock();

//    private static Person male=new Person("asdas",0,"male");
//    private static Person female=new Person("asdas",0,"female");

    private Person() {
    }

    public Person(String name, int age,String gender) {
        this.name = name;
        this.age = age;
        this.gender=gender;
    }

    public void eat() {
        System.out.println("eating");
    }

    public static Person getInstance(){
        lock.lock();
       if(instance==null){
           instance= new Person();
       }
        lock.unlock();
       return instance;
//        if (gender.equals("male")) return male;
//        else if (gender.equals("female")) return female;
//        return new Person();
    }
}
