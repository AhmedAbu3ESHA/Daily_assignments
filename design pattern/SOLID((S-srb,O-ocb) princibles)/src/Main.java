import model.Employee;
import services.IncomeCalculatorFactory;
import services.IncomeCalculatorInterface;
import services.NewIncomeCalculator;
import services.OldIncomeCalculator;
import test.IncomeCalculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees=List.of(
                new Employee("ahmed",20,2000,"new"),
        new Employee("hany",30,2500,"old"),
        new Employee("ahmed",22,4000,"new"),
        new Employee("ahmed",40,5000,"new")
        );

        printIncomes(employees);

//        EmployeeDAO employeeDAO=new EmployeeDAO(new Logger());
//        for (Employee employee : employees) {
//            employeeDAO.save(employee);
//        }

    }

    public static void printIncomes(List<Employee> employees){
        for (Employee employee : employees) {
            IncomeCalculator calculator=new IncomeCalculator();
            calculator.calculateIncome(employee,(emp)->{
                if(employee.getType().equals("new")){
                    System.out.println("new calculation");
                    int bonus=employee.getSalary()*3/100;
                    int tax=employee.getSalary()*15/100;
                    int support=employee.getSalary()*1/100;
                    int updatedSalary=employee.getSalary()+bonus+support-tax;
                    System.out.println(updatedSalary);
                }
                else{
                    System.out.println("old calculation");
                    int bonus=employee.getSalary()*5/100;
                    int tax=employee.getSalary()*10/100;
                    int updatedSalary=employee.getSalary()+bonus-tax;
                    System.out.println(updatedSalary);
                }

            });

//            IncomeCalculatorInterface incomeCalculator=
//                    IncomeCalculatorFactory.getIncomeCalculator(employee.getType());
//            incomeCalculator.calculateIncome(employee);
        }

    }
}