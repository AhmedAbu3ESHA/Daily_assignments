package template2;

public class LoanService extends BankService{

    private Loan loan;

    public LoanService(Loan loan) {
        this.loan = loan;
    }

    @Override
    public void onSave() {

        System.out.println("saving loan "+loan);
    }
}
