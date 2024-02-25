public class Main {
    public static void main(String[] args) {

       Thread t=new Thread(() -> {
           for (int i = 0; i < 100; i++)
               System.out.println("loop1 " + i);
       });
       t.start();

        for (int i = 0; i < 100; i++) {
            System.out.println("loop2 "+i);
        }
    }
}