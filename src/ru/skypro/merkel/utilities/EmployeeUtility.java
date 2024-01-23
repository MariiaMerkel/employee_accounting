package ru.skypro.merkel.utilities;

import ru.skypro.merkel.services.Employee;

public class EmployeeUtility {

    public static void addEmployee(Employee[] employees, Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return;
            }
        }
    }

    public static void printAll(Employee[] employees) {
        System.out.println("\nСотрудники: ");
        for (Employee e : employees) {
            if (e != null) {
                System.out.println("    " + e);
            }
        }
    }


    public static void printSumMonthlySalary(Employee[] employees) {
        int sum = 0;
        for (Employee e : employees) {
            if (e != null) {
                sum += e.getSalary();
            }
        }
        System.out.printf("\nСумма затрат на зарплаты в месяц = %d рублей.%n", sum);
    }

    public static void printWithMinSalary(Employee[] employees) {
        Employee employeeWithMinSalary = employees[0];
        for (Employee e : employees) {
            if (e != null && employeeWithMinSalary.getSalary() > e.getSalary()) {
                employeeWithMinSalary = e;
            }
        }
        System.out.println("\nСотрудники с наименьшей зарплатой: ");
        for (Employee e : employees) {
            if (e != null && e.getSalary() == employeeWithMinSalary.getSalary()) {
                System.out.println("    " + e);
            }
        }
    }

    public static void printWithMaxSalary(Employee[] employees) {
        Employee employeeWithMaxSalary = employees[0];
        for (Employee e : employees) {
            if (e != null && employeeWithMaxSalary.getSalary() < e.getSalary()) {
                employeeWithMaxSalary = e;
            }
        }
        System.out.println("\nСотрудники с наибольшей зарплатой: ");
        for (Employee e : employees) {
            if (e != null && e.getSalary() == employeeWithMaxSalary.getSalary()) {
                System.out.println("    " + e);
            }
        }
    }
}
