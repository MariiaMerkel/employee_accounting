package ru.skypro.merkel.services;

public class Employee {
    private final String firstName;
    private final String secondName;
    private final String lastName;
    private int department;
    private int salary;
    private final int id;
    private static int counter = 1;

    public Employee(String firstName, String secondName,String lastName,int department, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.id = getCounter();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getLastName() {
        return lastName;
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
        return String.format("%d. ФИО сотрудника: %s %s %s, отдел: %d, зарплата: %d рублей.", id, firstName, secondName, lastName, department, salary);
    }
}
