import java.util.List;
import java.util.Objects;

public class Loan {


    private double principleAmount;
    private double rate;
    private int loanYears;
    private double monthlyInstallments;
    private double finalAmount;

    public Loan(double principleAmount, double rate, int loanYears, double monthlyInstallments, double finalAmount) {
        this.principleAmount = principleAmount;
        this.rate = rate;
        this.loanYears = loanYears;
        this.monthlyInstallments = monthlyInstallments;
        this.finalAmount = finalAmount;
    }


    public double getPrincipleAmount() {
        return principleAmount;
    }

    public void setPrincipleAmount(double principleAmount) {
        this.principleAmount = principleAmount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getLoanYears() {
        return loanYears;
    }

    public void setLoanYears(int loanYears) {
        this.loanYears = loanYears;
    }

    public double getMonthlyInstallments() {
        return monthlyInstallments;
    }

    public void setMonthlyInstallments(double monthlyInstallments) {
        this.monthlyInstallments = monthlyInstallments;
    }

    public double getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(double finalAmount) {
        this.finalAmount = finalAmount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Loan)) return false;
        if (!super.equals(o)) return false;
        Loan loan = (Loan) o;
        return Double.compare(getPrincipleAmount(), loan.getPrincipleAmount()) == 0 && Double.compare(getRate(), loan.getRate()) == 0 && getLoanYears() == loan.getLoanYears() && Double.compare(getMonthlyInstallments(), loan.getMonthlyInstallments()) == 0 && Double.compare(getFinalAmount(), loan.getFinalAmount()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getPrincipleAmount(), getRate(), getLoanYears(), getMonthlyInstallments(), getFinalAmount());
    }

    @Override
    public String toString() {
        return "loan{" +
                "principleAmount=" + principleAmount +
                ", rate=" + rate +
                ", loanYears=" + loanYears +
                ", monthlyInstallments=" + monthlyInstallments +
                ", finalAmount=" + finalAmount +
                '}';
    }
}
