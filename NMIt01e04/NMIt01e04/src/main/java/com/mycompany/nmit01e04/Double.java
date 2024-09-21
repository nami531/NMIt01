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
public class Double extends Room {

    private static final double CHARGE = 1.20;
    
    public Double(boolean occupied) {
        super(100, occupied);
    }

    public Double() {
        super(100);
    }
    
    @Override
    public double checkOut(){
        super.setOccupied(false);
        LocalDate finalDate = LocalDate.now(); 
        long stayDays = super.getInitialDate().until(finalDate, ChronoUnit.DAYS);
        double bill; 
        if (finalDate.getMonthValue() == 4 || finalDate.getMonthValue() == 7 || finalDate.getMonthValue() == 8 ){
            bill = (stayDays * super.getPrice()) * CHARGE;
        } else {
            bill = (stayDays * super.getPrice()); 
        }
        return bill; 
    }
    
}
