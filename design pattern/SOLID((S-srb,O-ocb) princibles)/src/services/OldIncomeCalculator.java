package services;

import model.Employee;

public class OldIncomeCalculator implements IncomeCalculatorInterface {

    public int calculateIncome(Employee employee){
        System.out.println("old calculation");
        int bonus=employee.getSalary()*5/100;
        int tax=employee.getSalary()*10/100;
        int updatedSalary=employee.getSalary()+bonus-tax;
        return updatedSalary;
        //old
        //10 % tax
        //5 % bonus
        //basic salary

        //new
        //15 % tax
        //3 % bonus
        //1 % support
        //basic salary
    }
}
