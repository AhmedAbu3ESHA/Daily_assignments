package services;

public class Logger {

    public void printSuccess(String message){
        System.out.println(message);
    }

    public void printFailed(String error){
        System.out.println(error);
    }
}
