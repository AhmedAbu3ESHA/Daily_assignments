import java.util.Objects;

public class npv extends Trans {
    private int npv;
    private String npvState;


    public int getNpv() {
        return npv;
    }


    public void setNpv(int npv) {
        this.npv = npv;
    }


    public String getNpvState() {
        return npvState;
    }

    public npv(double amount, int year, int percent, double balance, String phone, int yearpayback) {
        super(amount, year, percent, balance, phone, yearpayback);
    }

    public npv(double amount, int year, int percent, double balance, String phone, int yearpayback, int npv, String npvState) {
        super(amount, year, percent, balance, phone, yearpayback);
        this.npv = npv;
        this.npvState = npvState;
    }

    public void setNpvState(String npvState) {
        this.npvState = npvState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof npv)) return false;
        if (!super.equals(o)) return false;
        npv npv1 = (npv) o;
        return getNpv() == npv1.getNpv() && Objects.equals(getNpvState(), npv1.getNpvState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getNpv(), getNpvState());
    }

    @Override
    public String toString() {
        return "npv{" +
                "npv=" + npv +
                ", npvState='" + npvState + '\'' +
                '}';
    }
}
