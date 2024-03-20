package singleton;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //high level modules ex:servlet ->services->model
        //low level modules->dao,connection

        //sevlet->service->businessl logic(model)->dao
        Person p=Person.getInstance();

    }
}
