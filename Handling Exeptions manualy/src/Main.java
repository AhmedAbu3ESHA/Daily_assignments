public class Main {
    public static void main(String[] args) {
        Account obj=new Account("Ahmed",100);
        try {
            obj.withdrow(200);
            obj.deposit(-50);
        } catch (AcountExeptions e) {
            System.out.println(e.getMessage());
        }

    }
}