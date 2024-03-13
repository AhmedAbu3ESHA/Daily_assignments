package services;

import model.Employee;

public class NewIncomeCalculator implements IncomeCalculatorInterface{
    @Override
    public int calculateIncome(Employee employee) {
        System.out.println("new calculation");
        int bonus=employee.getSalary()*3/100;
        int tax=employee.getSalary()*15/100;
        int support=employee.getSalary()*1/100;
        int updatedSalary=employee.getSalary()+bonus+support-tax;
        return updatedSalary;
    }
}
