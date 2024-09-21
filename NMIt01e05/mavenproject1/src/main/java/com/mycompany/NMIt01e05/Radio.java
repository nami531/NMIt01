/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.NMIt01e05;

/**
 *
 * @author nadia
 */
public class Radio implements Dispositive{
    private final long MAX = 104; 
    private final long MIN = 88; 
    private double state;

    public Radio(int state) {
        this.state = state;
    }

    public Radio() {
        this.state = MIN; 
    }

    public double getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    @Override
    public boolean up() {
        if (state + 0.1 <= MAX){
            state +=0.1; 
        }
        return state < MAX;
    }

    @Override
    public boolean down() {
        if (state - 0.1 >= MIN){
            state -=0.1; 
        } 
        return state  > MIN; 
    }

    @Override
    public void reset() {
        state = MIN; 
    }

    @Override
    public String checkState() {
        return "The radio is on channel " + state; 
    }
    
    
    
}
