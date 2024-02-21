public interface BankingOperation {
    double depitOperation( double amount);
    double creditOperation(double amount);
    double balance(double amount);
    int countTransaction(double amount);
    int sortingBalance(double amount);

}
