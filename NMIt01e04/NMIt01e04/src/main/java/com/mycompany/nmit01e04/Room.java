/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nmit01e04;

import java.time.LocalDate;

/**
 *
 * @author nadia
 */
public abstract class Room {
    private double price; 
    private boolean occupied; 
    private LocalDate initialDate; 

    public Room(double price, boolean occupied) {
        this.price = price;
        this.occupied = occupied;
    }

    public Room(double price) {
        this.price = price;
        this.occupied = false;
    }
    
    public void checkIn(){
        occupied = true; 
        LocalDate initialDate = LocalDate.now();
    }
    
    public abstract double checkOut(); 

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public void setInitialDate(LocalDate initialDate) {
        this.initialDate = initialDate;
    }

    public double getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public LocalDate getInitialDate() {
        return initialDate;
    }

    @Override
    public String toString() {
        return "Room{"+ "Type=" + this.getClass().getName().substring(24) + ", price=" + price + ", occupied=" + occupied + '}';
    }
    
    
}
