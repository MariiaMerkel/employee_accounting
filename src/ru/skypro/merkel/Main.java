package ru.skypro.merkel;

import ru.skypro.merkel.services.Employee;
import ru.skypro.merkel.utilities.EmployeeUtility;

public class Main {
    public static void main(String[] args) {
        EmployeeUtility employees = new EmployeeUtility(10);
        employees.add(new Employee("Харитонов", "Харитон", "Харитонович", 1, 100000));
        employees.add(new Employee("Иванов", "Иван", "Иванович", 1, 120000));
        employees.add(new Employee("Петров", "Иван","Иванович", 1, 100000));
        employees.add(new Employee("Сидоров", "Иван","Иванович", 5, 140005));
        employees.add(new Employee("Иванюк", "Иван","Иванович", 2, 130070));
        employees.add(new Employee("Пелагейкин", "Иван","Иванович", 3, 160000));
        employees.add(new Employee("Сёмина", "Елена", "Ивановна", 2, 100000));
        employees.add(new Employee("Ежова", "Елена", "Ивановна", 3, 160000));
        employees.add(new Employee("Ежова", "Елена", "Ивановна", 4, 125000));
        employees.add(new Employee("Ежова", "Алена", "Ивановна", 4, 125000));
        employees.add(new Employee("Ежова", "Юлия", "Ивановна", 4, 125000));
        employees.add(new Employee("Ежова", "Любовь", "Ивановна", 4, 125000));

        employees.delete("Ежова", "Елена", "Ивановна");
        employees.delete(1);

        employees.printAll();
        employees.printSumMonthlySalary();
        employees.printWithMinSalary();
        employees.printWithMaxSalary();
        employees.printFullNameAll();
        employees.printAverageSalary();

        employees.indexSalary(1.1f);
        employees.printAll();

        employees.updateSalaryById(2, 150000);
        employees.updateDepartmentById(3, 1);
        employees.updateSalaryByFullName("Петров Иван Иванович", 100000);
        employees.updateSalaryByFullName("jfjf", 12000);
        employees.updateDepartmentByFullName("Петров Иван Иванович", 4);

        for (int i = 1; i <= 5; i++) {
            employees.printWithMinSalaryInDepartment(i);
        }
        for (int i = 1; i <= 5; i++) {
            employees.printWithMaxSalaryInDepartment(i);
        }

        for (int i = 1; i <= 5; i++) {
            employees.printAverageSalaryInDepartment(1);
        }

        for (int i = 1; i <= 5; i++) {
            employees.printSumMonthlySalaryInDepartment(i);
        }

        employees.indexSalaryInDepartment(5, 1.8f);
        employees.printAll();

        for (int i = 1; i <= 5; i++) {
            employees.printOfDepartment(i);
        }
        employees.printBySalaryLess(120000);
        employees.printBySalaryMore(120000);

    }
}