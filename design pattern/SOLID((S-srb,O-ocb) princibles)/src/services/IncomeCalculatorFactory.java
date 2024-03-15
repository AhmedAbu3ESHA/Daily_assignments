package services;

public class IncomeCalculatorFactory {

    public static IncomeCalculatorInterface getIncomeCalculator(String type){
        if (type.equals("old")) return new OldIncomeCalculator();
        else if (type.equals("new")) return new NewIncomeCalculator();
        else return new OldIncomeCalculator();
    }
}
