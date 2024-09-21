/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.NMIt01e05;

import java.util.ArrayList;

/**
 *
 * @author nadia
 */
public class Building {
    private ArrayList<Dispositive> dispositives; 

    public Building() {
        dispositives = new ArrayList<>(); 
    }

    public ArrayList<Dispositive> getDispositives() {
        return dispositives;
    }
    
    public boolean addDispositive(Dispositive d){
        if(dispositives.contains(d)){
            return false; 
        } else {
            dispositives.add(d); 
            return true;
        }
        
    }
    
    
}
