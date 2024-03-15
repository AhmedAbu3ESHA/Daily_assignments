public class Trans {
    private double amount;
    private int year;
    private int percent;
    private String phone;
public String color="red";
    public Trans() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public Trans(double amount, int year, int percent, double balance,String phone) {
        this.amount = amount;
        this.year = year;
        this.percent = percent;
        this.balance = balance;
        this.phone= phone;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPercent() {
        return percent;
    }

    public void setPercent(int percent) {
        this.percent = percent;
    }
}
