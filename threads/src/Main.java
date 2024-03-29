public class Main {
    public static void main(String[] args) {

        //thread(task)
        Thread t=new Thread(() -> System.out.println("code"));
        t.start();

        System.out.println("code");

    }
}