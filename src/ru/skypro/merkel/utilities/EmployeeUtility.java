package ru.skypro.merkel.utilities;

import ru.skypro.merkel.services.Employee;

public class EmployeeUtility {
    private final Employee[] employees;

    public EmployeeUtility(int amount) {
        this.employees = new Employee[amount];
    }

    public void addEmployee(Employee e) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = e;
                System.out.printf("%nСотрудник %s добавлен.%n", getFullName(e));
                return;
            }
        }
        System.out.printf("%nДанные о сотруднике %s не добавлены, так как массив переполнен%n", getFullName(e));
    }

    public void deleteEmployee(String firstName, String secondName, String lastName) {
        int amountEligible = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null &&
                    employees[i].getFirstName().equals(firstName) &&
                    employees[i].getSecondName().equals(secondName) &&
                    employees[i].getLastName().equals(lastName)) {
                amountEligible++;
            }
        }
        if (amountEligible == 1) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null &&
                        employees[i].getFirstName().equals(firstName) &&
                        employees[i].getSecondName().equals(secondName) &&
                        employees[i].getLastName().equals(lastName)) {
                    System.out.printf("%nСотрудник %s удалён.%n", getFullName(employees[i]));
                    employees[i] = null;
                }
            }
        } else {
            System.out.println("\nНайдено несколько сотрудников с такими Ф.И.О. Введите id сотрудника для его удаления");
        }
    }

    public void deleteEmployee(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                System.out.printf("Сотрудник %s удалён.%n", getFullName(employees[i]));
                employees[i] = null;
            }
        }
    }

    public int findEmployeeByFullName(String firstName, String secondName, String lastName) {
        int amountEligible = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null &&
                    employees[i].getFirstName().equals(firstName) &&
                    employees[i].getSecondName().equals(secondName) &&
                    employees[i].getLastName().equals(lastName)) {
                amountEligible++;
            }
        }
        if (amountEligible == 1) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null &&
                        employees[i].getFirstName().equals(firstName) &&
                        employees[i].getSecondName().equals(secondName) &&
                        employees[i].getLastName().equals(lastName)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void updateSalaryById(int id, int newSalary) {
        try {
            employees[id].setSalary(newSalary);
        } catch (RuntimeException e) {
            System.out.println("\nСотрудник с таким id не найден.");
        }
    }

    public void updateDepartmentById(int id, int newDepartment) {
        try {
            employees[id].setDepartment(newDepartment);
        } catch (RuntimeException e) {
            System.out.println("\nСотрудник с таким id не найден.");
        }
    }

    public void updateSalaryByFullName(String firstName, String secondName, String lastName, int newSalary) {
        if (findEmployeeByFullName(firstName, secondName, lastName) != -1) {
            employees[findEmployeeByFullName(firstName, secondName, lastName)].setSalary(newSalary);
        } else {
            System.out.println("\nНайдено несколько сотрудников с такими Ф.И.О. Введите id сотрудника.");
        }
    }

    public void updateDepartmentByFullName(String firstName, String secondName, String lastName, int newDepartment) {
        if (findEmployeeByFullName(firstName, secondName, lastName) != -1) {
            employees[findEmployeeByFullName(firstName, secondName, lastName)].setDepartment(newDepartment);
        } else {
            System.out.println("\nНайдено несколько сотрудников с такими Ф.И.О. Введите id сотрудника.");
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
                System.out.printf("    %s" , getFullName(e));
            }
        }
    }

    public void indexSalary(float percent) {
        for (Employee e : employees) {
            if (e != null) {
                e.setSalary((int) (percent * e.getSalary()));
            }
        }
        System.out.println("Зарплата сотрудников проиндексирована.");
    }

    public void indexSalary(Employee[] employees, float percent) {
        for (Employee e : employees) {
            if (e != null) {
                e.setSalary((int) (percent * e.getSalary()));
            }
        }
        System.out.println("Зарплата сотрудников проиндексирована.");
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
        System.out.println("Зарплата сотрудников проиндексирована.");
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
            System.out.printf("    %d. ФИО сотрудника: %s, зарплата: %d рублей.%n", getFullName(e), e.getSalary());
        }
    }

    public String getFullName(Employee e) {
        return String.format("%s %s %s", e.getFirstName(), e.getSecondName(), e.getLastName());
    }
}
