/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.NMIt01e05;

/**
 *
 * @author nadia
 */
public class Elevator implements Dispositive {
    private final int MAX = 8; 
    private final int MIN = 0; 
    private int state; 

    public Elevator(int state) {
        this.state = state;
    }

    public Elevator() {
        this.state = MIN;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
        state = MIN; 
    }

    @Override
    public String checkState() {
        return "The elevator is in floor " + state; 
    }
    
   
}
