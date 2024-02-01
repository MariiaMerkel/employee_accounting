package ru.skypro.merkel.utilities;

import ru.skypro.merkel.services.Employee;

import java.text.NumberFormat;

public class EmployeeUtility {
    private final Employee[] employees;
    private final NumberFormat numberFormat = NumberFormat.getCurrencyInstance();

    public EmployeeUtility(int amount) {
        this.employees = new Employee[amount];
    }

    public void add(Employee e) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = e;
                System.out.printf("%nСотрудник %s добавлен.%n", e.getFullName());
                return;
            }
        }
        System.out.printf("%nДанные о сотруднике %s не добавлены, так как массив переполнен%n", e.getFullName());
    }

    public void delete(String firstName, String secondName, String lastName) {
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
                    System.out.printf("%nСотрудник %s удалён.%n", employees[i].getFullName());
                    employees[i] = null;
                }
            }
        } else {
            System.out.println("\nНайдено несколько сотрудников с такими Ф.И.О. Введите id сотрудника для его удаления");
        }
    }

    public void delete(int id) {
        if (id <= employees.length && employees[id] != null) {
            System.out.printf("Сотрудник %s удалён.%n", employees[id].getFullName());
            employees[id] = null;
        } else {
            System.out.println("\nСотрудник с такими id не найден.");
        }
    }

    public Employee findEmployeeByFullName(String fullName) {
        int amountEligible = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                amountEligible++;
            }
        }
        if (amountEligible == 1) {
            for (int i = 0; i < employees.length; i++) {
                if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                    return employees[i];
                }
            }
        }
        return null;
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
        System.out.printf("%nСумма затрат на зарплаты всех сотрудников в месяц = %s.%n", numberFormat.format(calculateSumMonthlySalary(employees)));
    }

    public Employee findByMinSalary() {
        Employee employeeWithMinSalary = employees[0];
        for (Employee e : employees) {
            if (e != null && employeeWithMinSalary.getSalary() > e.getSalary()) {
                employeeWithMinSalary = e;
            }
        }
        return employeeWithMinSalary;
    }

    public void printWithMinSalary() {
        Employee employeeWithMinSalary = findByMinSalary();
        System.out.println("\nСотрудники с наименьшей зарплатой: ");
        for (Employee e : employees) {
            if (e != null && e.getSalary() == employeeWithMinSalary.getSalary()) {
                System.out.println("    " + e);
            }
        }
    }

    public Employee findByMaxSalary() {
        Employee employeeWithMaxSalary = employees[0];
        for (Employee e : employees) {
            if (e != null && employeeWithMaxSalary.getSalary() < e.getSalary()) {
                employeeWithMaxSalary = e;
            }
        }
        return employeeWithMaxSalary;
    }

    public void printWithMaxSalary() {
        Employee employeeWithMaxSalary = findByMaxSalary();
        System.out.println("\nСотрудники с наибольшей зарплатой: ");
        for (Employee e : employees) {
            if (e != null && e.getSalary() == employeeWithMaxSalary.getSalary()) {
                System.out.println("    " + e);
            }
        }
    }

    public void printAverageSalary() {
        System.out.printf("%nСреднее значение зарплат = %s .%n", numberFormat.format(calculateAverageSalary()));
    }

    public float calculateAverageSalary() {
        int sum = calculateSumMonthlySalary(employees);
        if (calculateEmployees() != 0) {
            return (float) sum / calculateEmployees();
        }
        return 0f;
    }

    public int calculateEmployees() {
        int c = 0;
        for (Employee e : employees) {
            if (e != null) {
                c++;
            }
        }
        return c;
    }

    public void printFullNameAll() {
        System.out.println("\nФ.И.О. всех сотрудников: ");
        for (Employee e : employees) {
            if (e != null) {
                System.out.printf("    %s%n", e.getFullName());
            }
        }
    }

    public void indexSalary(float percent) {
        for (Employee e : employees) {
            if (e != null) {
                e.setSalary((int) (percent * e.getSalary()));
            }
        }
        System.out.println("\nЗарплата сотрудников проиндексирована.");
    }

    public void indexSalary(Employee[] employees, float percent) {
        for (Employee e : employees) {
            if (e != null) {
                e.setSalary((int) (percent * e.getSalary()));
            }
        }
        System.out.println("\nЗарплата сотрудников проиндексирована.");
    }

    public void updateSalaryById(int id, int newSalary) {
        if (id < this.employees.length) {
            System.out.printf("%nЗарплата сотрудника %s изменена с %s на %s.%n", employees[id].getFullName(), numberFormat.format(employees[id].getSalary()), numberFormat.format(newSalary));
            employees[id].setSalary(newSalary);
        } else {
            System.out.println("\nСотрудник с таким id не найден.");
        }
    }

    public void updateDepartmentById(int id, int newDepartment) {
        if (id < employees.length) {
            System.out.printf("%nОтдел сотрудника %s изменена с %d на %d.%n", employees[id].getFullName(), employees[id].getDepartment(), newDepartment);
            employees[id].setDepartment(newDepartment);
        } else {
            System.out.println("\nСотрудник с таким id не найден.");
        }
    }

    public void updateSalaryByFullName(String fullName, int newSalary) {
        Employee e = findEmployeeByFullName(fullName);
        if (e != null) {
            System.out.printf("%nЗарплата сотрудника %s изменена с %s на %s%n", e.getFullName(), numberFormat.format(e.getSalary()), numberFormat.format(newSalary));
            e.setSalary(newSalary);
        } else {
            System.out.println("\nСотрудников с такими Ф.И.О. не найдено или найдено несколько. Введите id сотрудника.");
        }
    }

    public void updateDepartmentByFullName(String fullName, int newDepartment) {
        Employee e = findEmployeeByFullName(fullName);
        if (e != null) {
            System.out.printf("%nОтдел сотрудника %s изменена с %d на %d%n", e.getFullName(), e.getDepartment(), newDepartment);
            e.setDepartment(newDepartment);
        } else {
            System.out.println("\nСотрудников с такими Ф.И.О. не найдено или найдено несколько. Введите id сотрудника.");
        }
    }

    public void printWithMinSalaryInDepartment(int department) {
        Employee[] employeesDep = findEmployeesOfDepartment(department);
        if (employeesDep.length != 0) {
            Employee employeeWithMinSalary = employeesDep[0];
            for (Employee e : employeesDep) {
                if (employeeWithMinSalary.getSalary() > e.getSalary()) {
                    employeeWithMinSalary = e;
                }
            }
            System.out.printf("%nСотрудники с наименьшей зарплатой отдела № %d:%n", department);
            for (Employee e : employeesDep) {
                if (e != null && e.getSalary() == employeeWithMinSalary.getSalary()) {
                    System.out.println("    " + e);
                }
            }
        }
    }

    public void printWithMaxSalaryInDepartment(int department) {
        Employee[] employeesDep = findEmployeesOfDepartment(department);
        if (employeesDep.length != 0) {
            Employee employeeWithMaxSalary = employeesDep[0];
            for (Employee e : employeesDep) {
                if (employeeWithMaxSalary.getSalary() < e.getSalary()) {
                    employeeWithMaxSalary = e;
                }
            }
            System.out.printf("%nСотрудники с наибольшей зарплатой отдела № %d:%n", department);
            for (Employee e : employeesDep) {
                if (e.getSalary() == employeeWithMaxSalary.getSalary()) {
                    System.out.println("    " + e);
                }
            }
        }
    }

    public void printSumMonthlySalaryInDepartment(int department) {
        System.out.printf("%nСумма затрат на зарплаты в отделе № %d за месяц = %s.%n", department, numberFormat.format(calculateSumMonthlySalary(findEmployeesOfDepartment(department))));
    }

    public Employee[] findEmployeesOfDepartment(int department) {
        int c = 0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                c++;
            }
        }
        Employee[] employeesOfDepartment = new Employee[c];
        int i = 0;
        for (Employee e : employees) {
            if (e != null && e.getDepartment() == department) {
                employeesOfDepartment[i++] = e;
            }
        }
        return employeesOfDepartment;
    }

    public void printAverageSalaryInDepartment(int department) {
        Employee[] employeesOfDepartment = findEmployeesOfDepartment(department);
        int sum = calculateSumMonthlySalary(employeesOfDepartment);
        System.out.printf("%nСреднее значение зарплат отдела № %d = %s.%n", department, numberFormat.format((float) sum / employeesOfDepartment.length));
    }

    public void indexSalaryInDepartment(int department, float percent) {
        this.indexSalary(findEmployeesOfDepartment(department), percent);
        System.out.printf("%nЗарплата сотрудников отдела №%d проиндексирована.%n", department);
    }

    public void printOfDepartment(int department) {
        Employee[] employeesDep = findEmployeesOfDepartment(department);
        System.out.printf("%nСотрудники отдела № %d:%n", department);
        for (Employee e : employeesDep) {
            printIdFullNameSalary(e);
        }
    }

    public void printBySalaryLess(int limit) {
        System.out.printf("%nСотрудники с зарплатой меньше %s:%n", numberFormat.format(limit));
        for (Employee e : employees) {
            if (e != null && e.getSalary() <= limit) {
                printIdFullNameSalary(e);
            }
        }
    }

    public void printBySalaryMore(int limit) {
        System.out.printf("%nСотрудники с зарплатой больше %s:%n", numberFormat.format(limit));
        for (Employee e : employees) {
            if (e != null && e.getSalary() >= limit) {
                printIdFullNameSalary(e);
            }
        }
    }

    public void printIdFullNameSalary(Employee e) {
        if (e != null) {
            System.out.printf("    %d. ФИО сотрудника: %s, зарплата: %s.%n", e.getId(), e.getFullName(), numberFormat.format(e.getSalary()));
        }
    }

}
