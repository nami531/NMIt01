/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.nmit01e04;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author nadia
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hotel h = new Hotel();
        for (int i = 0; i < 3; i++) {
            Lowcost r = new Lowcost(); 
            h.getRooms().add(r); 
        }
        for (int i = 0; i < 10; i++) {
            Double r = new Double(); 
            h.getRooms().add(r);             
        }
        for (int i = 0; i < 5; i++) {
            Suite r = new Suite(); 
            h.getRooms().add(r);             
        }
        
        // System.out.println(h.getRooms());
        
        
        boolean menu = true; 
        while (menu){
            System.out.println("""
                           What do you want to do?
                           1. Check-in
                           2. Check-out
                           3. List the available rooms
                           4. List the occupied rooms
                           5. Exit""");
            Scanner sc = new Scanner(System.in); 
            int ans = sc.nextInt();
            
            ArrayList<Room> rooms = h.getRooms(); 
            Room[] roomTypes = {new Lowcost(), new Double(), new Suite()};
            if (ans == 1){
                System.out.println("""
                                   Which type of room: 
                                   1. Lowcost
                                   2. Double
                                   3. Suite
                                   """);
                int ans2 = sc.nextInt();
                boolean booked = false;
                for (int i = 0; i< rooms.size() && !booked; i++) {
                    Room room = rooms.get(i); 
                    if (!(room.isOccupied()) && room.getClass() == roomTypes[ans2-1].getClass()){ /*You can use an instanceof operator, but it can't work with the array*/
                        room.checkIn();
                        booked = true; 
                        System.out.println("Room has been booked succesfully");
                    } 
                }System.out.println("Sorry we can´t offer you a room");
                    
            } else if (ans == 2){
                 System.out.println("""
                                   Which type of room: 
                                   1. Lowcost
                                   2. Double
                                   3. Suite
                                   """);
                int ans2 = sc.nextInt();
                System.out.println("Enter the check-in date: ");
                LocalDate checkinDate = LocalDate.parse(sc.next()); 
                boolean paid = false;
                for (int i = 0; i< rooms.size() && !paid; i++) {
                    Room room = rooms.get(i); 
                    if ((room.isOccupied() && room.getInitialDate() == checkinDate) && room.getClass() == roomTypes[ans2-1].getClass())                                
                        System.out.println("You need to pay " + room.checkOut() + "€" );
                        paid = true; 
                }
            } else if (ans == 3) {
                for (Room room : rooms) {                
                        if (!room.isOccupied()){
                            System.out.println(room);
                        }                    
                }
            } else if (ans == 4) {
                for (Room room : rooms) {
                    if (room.isOccupied()){
                        System.out.println(room);
                    }
                }
            } else if (ans == 5) {
                menu = false; 
            } else {
                System.out.println("You typed wrong");
            }
        }
    }
    
}
