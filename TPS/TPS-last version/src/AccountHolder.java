public class AccountHolder{
    private String customerName;
    private String accountNumber;
    private double accountBalance;



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
            accountBalance-= amount;
            System.out.println("your new balance  "+accountBalance);
        return accountBalance;
    }

    public double creditOperation(double amount) {
            accountBalance+= amount;
            setAccountBalance(accountBalance);
            System.out.println("your new balance "+accountBalance);
        return accountBalance;
    }
}
