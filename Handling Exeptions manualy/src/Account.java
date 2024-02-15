public class Account {
private String name;
private int balance;

    public Account(String name, int palanse) {
        this.name = name;
        this.balance = palanse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void deposit(int amount) throws AcountExeptions {
        if(amount<0) {
            throw new AcountExeptions(Enumex.NegativeDeposit);
        }
        balance +=amount;
    }

    public void withdrow(int amount) throws AcountExeptions {
        if(amount>balance) {
            throw new AcountExeptions(Enumex.InsuffeicientBalance);
        }
        balance -=amount;
    }

}

