package ru.skypro.merkel.services;

public class Employee {
    private final String fullName;
    private int department;
    private int salary;
    private final int id;
    private static int counter = 1;

    public Employee(String fullName, int department, int salary) {
        this.fullName = fullName;
        this.department = department;
        this.salary = salary;
        this.id = getCounter();
    }

    public String getFullName() {
        return fullName;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static int getCounter() {
        return counter++;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return String.format("%d. ФИО сотрудника: %s, отдел: %d, зарплата: %d рублей.", id, fullName, department, salary);
    }
}
