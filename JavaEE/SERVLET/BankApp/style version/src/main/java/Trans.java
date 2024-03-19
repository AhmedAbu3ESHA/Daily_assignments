import java.util.Objects;

public class Trans {
    private double amount;
    private int year;
    private int percent;
    private String phone;
    private int yearpayback;
    private int npv;
    private String npvState;

    public String getNpvState() {
        return npvState;
    }

    public void setNpvState(String npvState) {
        this.npvState = npvState;
    }

    public int getNpv() {
        return npv;
    }

    public void setNpv(int npv) {
        this.npv = npv;
    }

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
    public Trans(double amount, int year, int percent, double balance,String phone,int yearpayback) {
        this.amount = amount;
        this.year = year;
        this.percent = percent;
        this.balance = balance;
        this.phone= phone;
        this.yearpayback = yearpayback;
    }


    public Trans(double amount, int year, int percent, String phone, int npv,String npvState) {
        this.amount = amount;
        this.year = year;
        this.percent = percent;
        this.phone = phone;
        this.npv = npv;
        this.npvState=npvState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trans trans = (Trans) o;
        return Double.compare(amount, trans.amount) == 0 && year == trans.year && percent == trans.percent;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, year, percent);
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
