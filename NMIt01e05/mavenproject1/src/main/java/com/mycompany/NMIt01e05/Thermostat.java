/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.NMIt01e05;

import java.time.LocalDate;

/**
 *
 * @author nadia
 */
public class Thermostat  implements Dispositive {
    private final int MAX = 80; 
    private final int MIN = 15; 
    private long state;
    private LocalDate revision; 

    public Thermostat(long state, LocalDate revision) {
        this.state = state;
        this.revision = revision;
    }

    public Thermostat() {
        this.state = 20;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public LocalDate getRevision() {
        return revision;
    }

    public void setRevision(LocalDate revision) {
        this.revision = revision;
    }
    
    @Override
    public boolean up() {
        if (state + 1 < MAX){
            state++; 
        } 
        return state < MAX;
    }

    @Override
    public boolean down() {
        if (state - 1 >= MIN){
            state--; 
        }
        return state > MIN;  
    }

    @Override
    public void reset() {
        state = 20; 
    }

    @Override
    public String checkState() {
        return "The thermostat is " + state + "ºC"; 
    }   
    
    public void inspect(){
        revision = LocalDate.now(); 
    }
    
    
}
