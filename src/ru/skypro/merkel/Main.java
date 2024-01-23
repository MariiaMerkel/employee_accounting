package ru.skypro.merkel;

import ru.skypro.merkel.services.Employee;
import ru.skypro.merkel.utilities.EmployeeUtility;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[10];
        Employee haritonov = new Employee("Харитонов Харитон Харитонович", 1, 100000);
        Employee ivanov = new Employee("Иванов Иван Иванович", 1, 120000);
        Employee petrov = new Employee("Петров Иван Иванович", 5, 110000);
        Employee sidorov = new Employee("Сидоров Иван Иванович", 9, 140000);
        Employee ivanuk = new Employee("Иванюк Иван Иванович", 6, 130000);
        Employee pelageykin = new Employee("Пелагейкин Иван Иванович", 3, 160000);
        Employee semina = new Employee("Сёмина Елена Ивановна", 2, 100000);
        Employee ezhova = new Employee("Ежёва Елена Ивановна", 7, 160000);

        EmployeeUtility.addEmployee(employees, haritonov);
        EmployeeUtility.addEmployee(employees, ivanov);
        EmployeeUtility.addEmployee(employees, petrov);
        EmployeeUtility.addEmployee(employees, sidorov);
        EmployeeUtility.addEmployee(employees, ivanuk);
        EmployeeUtility.addEmployee(employees, pelageykin);
        EmployeeUtility.addEmployee(employees, semina);
        EmployeeUtility.addEmployee(employees, ezhova);

        EmployeeUtility.printAll(employees);
        EmployeeUtility.printSumMonthlySalary(employees);
        EmployeeUtility.printWithMinSalary(employees);
        EmployeeUtility.printWithMaxSalary(employees);
    }
}