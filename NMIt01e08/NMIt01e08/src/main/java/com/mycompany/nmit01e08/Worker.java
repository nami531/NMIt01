/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nmit01e08;

/**
 *
 * @author nadia
 */
public class Worker {
    private long id; 
    private String name; 
    private double salary; 

    public Worker(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Worker(long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    
    
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
}
