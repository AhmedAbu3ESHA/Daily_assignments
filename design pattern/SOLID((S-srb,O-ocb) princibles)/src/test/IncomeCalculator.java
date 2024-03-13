package test;

import model.Employee;
import services.IncomeCalculatorInterface;

import java.sql.Types;
import java.util.function.Consumer;
import java.util.function.Function;

public class IncomeCalculator {

    public void calculateIncome(Employee employee, Consumer<Employee> consumer) {
        consumer.accept(employee);

//        if(employee.getType().equals("new")){
//            System.out.println("new calculation");
//            int bonus=employee.getSalary()*3/100;
//            int tax=employee.getSalary()*15/100;
//            int support=employee.getSalary()*1/100;
//            int updatedSalary=employee.getSalary()+bonus+support-tax;
//            return updatedSalary;
//        }
//        else{
//            System.out.println("old calculation");
//            int bonus=employee.getSalary()*5/100;
//            int tax=employee.getSalary()*10/100;
//            int updatedSalary=employee.getSalary()+bonus-tax;
//            return updatedSalary;
//        }

    }
}
