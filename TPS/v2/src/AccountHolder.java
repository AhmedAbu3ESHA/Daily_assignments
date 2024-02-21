public class AccountHolder{
    private String customerName;
    private String accountNumber;
    private double accountBalance;

    public int numberOfTransaction=0;
    public int failedTransaction ;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getNumberOfTransaction() {
        return numberOfTransaction;
    }

    public void setNumberOfTransaction(int numberOfTransaction) {
        this.numberOfTransaction = numberOfTransaction;
    }

    public int getFailedTransaction() {
        return failedTransaction;
    }

    public void setFailedTransaction(int failedTransaction) {
        this.failedTransaction = failedTransaction;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public AccountHolder() {
    }

    public AccountHolder(String customerName, String accountNumber, double accountBalance) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "AccountHolder{" +
                "customerName='" + customerName + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }


    public double debitOperation(double amount) {
        if (amount> accountBalance) {
            System.out.println("not enough");
            failedTransaction++;
        } else {
            accountBalance-= amount;
            numberOfTransaction++;
            System.out.println("your new balance  "+accountBalance);
        }
        return accountBalance;
    }

    public double creditOperation(double amount) {
        if (amount< 0) {
            System.out.println("negative deposit");
            failedTransaction++;
        } else {
            accountBalance+= amount;
            setAccountBalance(accountBalance);
            numberOfTransaction++;
            System.out.println("your new balance "+accountBalance);
        }
        return accountBalance;
    }



    public double balance(double amount) {

        return 0;
    }


}
