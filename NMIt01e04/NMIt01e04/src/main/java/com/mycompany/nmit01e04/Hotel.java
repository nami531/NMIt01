/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nmit01e04;

import java.util.ArrayList;

/**
 *
 * @author nadia
 */
public class Hotel {
    private ArrayList<Room> rooms; 

    public Hotel() {
        rooms = new ArrayList<>(); 
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void setRooms(ArrayList<Room> rooms) {
        this.rooms = rooms;
    }
    
    
}
