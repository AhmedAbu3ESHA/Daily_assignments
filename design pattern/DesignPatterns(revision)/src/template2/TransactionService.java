package template2;

public class TransactionService extends BankService{

    private Transaction transaction;

    public TransactionService(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void onSave() {
        System.out.println("saving trabsaction "+transaction);
    }
}
