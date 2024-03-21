import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trans {



    private double amount;
    private int year;
    private int percent;
    private String phone;
    private int yearpayback;
    private double balance;
    public Trans() {
    }

    public int getYearpayback() {
        return yearpayback;
    }

    public void setYearpayback(int yearpayback) {
        this.yearpayback = yearpayback;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }



    public Trans(double amount, int year, int percent, double balance,String phone,int yearpayback) {
        this.amount = amount;
        this.year = year;
        this.percent = percent;
        this.balance = balance;
        this.phone= phone;
        this.yearpayback = yearpayback;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trans)) return false;
        Trans trans = (Trans) o;
        return Double.compare(getAmount(), trans.getAmount()) == 0 && getYear() == trans.getYear() && getPercent() == trans.getPercent() && getYearpayback() == trans.getYearpayback() && Double.compare(getBalance(), trans.getBalance()) == 0 && Objects.equals(getPhone(), trans.getPhone());
    }


    @Override
    public int hashCode() {
        return Objects.hash(getAmount(), getYear(), getPercent(), getPhone(), getYearpayback(), getBalance());
    }

}
