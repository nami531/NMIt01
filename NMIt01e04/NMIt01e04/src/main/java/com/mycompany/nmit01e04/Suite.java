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
public class Suite extends Room{
    
    private final double DISCOUNT = 0.2; 

    public Suite(boolean occupied) {
        super(200, occupied); 
    }

    public Suite() {
        super(200); 
    }

    @Override
    public double checkOut() {
        super.setOccupied(false);
        LocalDate finalDate = LocalDate.now(); 
        long stayDays = super.getInitialDate().until(finalDate, ChronoUnit.DAYS); 
        return stayDays >= 10 ? (stayDays * super.getPrice()) * (1 - DISCOUNT) : stayDays * super.getPrice(); 
    }
    
    
    
    
}
