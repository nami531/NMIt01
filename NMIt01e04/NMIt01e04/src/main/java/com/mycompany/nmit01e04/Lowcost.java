/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nmit01e04;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author nadia
 */
public class Lowcost extends Room {

 
    
    public Lowcost(boolean occupied) {
        super(50, occupied); 
    }

    public Lowcost() {
        super(50); 
    }

    @Override
    public double checkOut() {
        super.setOccupied(false);
        LocalDate finalDate = LocalDate.now(); 
        long stayDays = super.getInitialDate().until(finalDate, ChronoUnit.DAYS); 
        long bill = (long) (stayDays * super.getPrice()); 
        return bill; 
    }
    
    
    
}
