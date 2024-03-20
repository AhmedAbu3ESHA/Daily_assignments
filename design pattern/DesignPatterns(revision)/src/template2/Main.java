package template2;

public class Main {
    public static void main(String[] args) {

        TransactionService transactionService=new TransactionService(new Transaction(2000));
        transactionService.save("loan");
    }
}
