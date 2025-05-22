package com.example;

//import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {
    
    @Id
    private int id;

    private String name;
    private String department;
    private double salary;

    // Getters and Setters
}
