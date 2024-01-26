package ru.skypro.merkel.utilities;

import ru.skypro.merkel.services.Employee;

public class EmployeeUtility {
    private Employee[] employees;

    public EmployeeUtility(int amount) {
        this.employees = new Employee[amount];
    }

    public void addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return;
            }
        }
    }

    public void printAll() {
        System.out.println("\nПолная информация о всех сотрудниках: ");
        for (Employee e : employees) {
            if (e != null) {
                System.out.println("    " + e);
            }
        }
    }

    public int calculateSumMonthlySalary(Employee[] employees) {
        int sum = 0;
        for (Employee e : employees) {
            if (e != null) {
                sum += e.getSalary();
            }
        }
        return sum;
    }

    public void printSumMonthlySalary() {
        System.out.printf("%nСумма затрат на зарплаты всех сотрудников в месяц = %d рублей.%n", calculateSumMonthlySalary(employees));
    }

    public void printWithMinSalary() {
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

    public void printWithMaxSalary() {
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

    public void printAverageSalary() {
        int sum = calculateSumMonthlySalary(employees);
        int c = 0;
        for (Employee e : employees) {
            if (e != null) {
                c++;
            }
        }
        if (c != 0) {
            System.out.printf("%nСреднее значение зарплат = %.2f рублей.%n", (float) sum / c);
        }
    }

    public void printFullNameAll() {
        System.out.println("\nФ.И.О. всех сотрудников: ");
        for (Employee e : employees) {
            if (e != null) {
                System.out.println("    " + e.getFullName());
            }
        }
    }

    public void indexSalary(float percent) {
        for (Employee e : employees) {
            if (e != null) {
                e.setSalary((int) (percent * e.getSalary()));
            }
        }
    }

    public void indexSalary(Employee[] employees, float percent) {
        for (Employee e : employees) {
            if (e != null) {
                e.setSalary((int) (percent * e.getSalary()));
            }
        }
    }

    public void printWithMinSalaryInDepartment(int department) {
        if (findEmployeesOfDepartment(department)[0] != null) {
            Employee employeeWithMinSalary = findEmployeesOfDepartment(department)[0];
            for (Employee e : employees) {
                if (e != null && employeeWithMinSalary.getSalary() > e.getSalary() && e.getDepartment() == department) {
                    employeeWithMinSalary = e;
                }
            }
            System.out.printf("%nСотрудники с наименьшей зарплатой отдела № %d:%n", department);
            for (Employee e : employees) {
                if (e != null && e.getSalary() == employeeWithMinSalary.getSalary() && e.getDepartment() == department) {
                    System.out.println("    " + e);
                }
            }
        }
    }

    public void printWithMaxSalaryInDepartment(int department) {
        if (findEmployeesOfDepartment(department)[0] != null) {
            Employee employeeWithMaxSalary = findEmployeesOfDepartment(department)[0];
            for (Employee e : employees) {
                if (e != null && employeeWithMaxSalary.getSalary() < e.getSalary() && e.getDepartment() == department) {
                    employeeWithMaxSalary = e;
                }
            }
            System.out.printf("%nСотрудники с наибольшей зарплатой отдела № %d:%n", department);
            for (Employee e : employees) {
                if (e != null && e.getSalary() == employeeWithMaxSalary.getSalary() && e.getDepartment() == department) {
                    System.out.println("    " + e);
                }
            }
        }
    }

    public void printSumMonthlySalaryInDepartment(int department) {
        System.out.printf("%nСумма затрат на зарплаты в отделе № %d за месяц = %d рублей.%n", department, calculateSumMonthlySalary(findEmployeesOfDepartment(department)));
    }

    public Employee[] findEmployeesOfDepartment(int department) {
        Employee[] employeesOfDepartment = new Employee[employees.length];
        int i = 0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                employeesOfDepartment[i++] = e;
            }
        }
        return employeesOfDepartment;
    }

    public void printAverageSalaryInDepartment(int department) {
        int c = 0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                c++;
            }
        }

        Employee[] employeesOfDepartment = new Employee[employees.length];
        int i = 0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                employeesOfDepartment[i++] = e;
            }
        }
        int sum = calculateSumMonthlySalary(employeesOfDepartment);
        System.out.printf("%nСреднее значение зарплат отдела № %d = %.2f рублей.%n", department, (float) sum / c);
    }

    public void indexSalaryInDepartment(int department, float percent) {
        this.indexSalary(findEmployeesOfDepartment(department), percent);
    }

    public void printOfDepartment(int department) {
        System.out.printf("%nСотрудники отдела № %d:%n", department);
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                printIdFullNameSalary(e);
            }
        }
    }

    public void printBySalaryLess(int limit) {
        System.out.printf("%nСотрудники с зарплатой меньше %d рублей:%n", limit);
        for (Employee e : employees) {
            if (e != null && e.getSalary() <= limit) {
                printIdFullNameSalary(e);
            }
        }
    }

    public void printBySalaryMore(int limit) {
        System.out.printf("%nСотрудники с зарплатой больше %d рублей:%n", limit);
        for (Employee e : employees) {
            if (e != null && e.getSalary() >= limit) {
                printIdFullNameSalary(e);
            }
        }
    }

    public void printIdFullNameSalary(Employee e) {
        if (e != null) {
            System.out.printf("    %d. ФИО сотрудника: %s, зарплата: %d рублей.%n", e.getId(), e.getFullName(), e.getSalary());
        }
    }
}
