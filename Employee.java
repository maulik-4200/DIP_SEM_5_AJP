package com.example.p6;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import javax.persistence.*;
import java.util.List;

// Entity class for Employee
@Entity
@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private double salary;
    private String department;

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }
    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    // Main methods for CRUD
    public static void saveEmployee(Employee employee) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public static List<Employee> fetchEmployees() {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        List<Employee> employees = session.createQuery("from Employee", Employee.class).list();
        session.close();
    }
}