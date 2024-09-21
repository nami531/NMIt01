/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.NMIt01e05;

import com.mycompany.NMIt01e05.Dispositive;
import java.util.Scanner;

/**
 *
 * @author nadia
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        Thermostat t = new Thermostat(); 
        Elevator e = new Elevator(); 
        Radio r = new Radio(); 
        
        Building b = new Building();
        
        b.addDispositive(t); 
        b.addDispositive(e); 
        b.addDispositive(r);
        // To check if it works succesfully 
        b.addDispositive(r);
        
        boolean menu = true; 
        
        while (menu){
        
            for (Dispositive d : b.getDispositives()) {
                System.out.println(d.checkState());
            }

            System.out.println("""
                               -----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                               0: Exit
                               1: Up a dispositive
                               2: Down a dispositive
                               3: Reset a dispositive
                               4: Inspect thermostat"""); 
            int ans = sc.nextInt(); 
            if (ans == 0){
                menu = false; 
            } else if (ans >= 1 && ans <= 3) {
                System.out.println("""
                                   Which dispositive:
                                   1. Radio
                                   2. Elevator
                                   3. Thermostat""");
                int ans2 = sc.nextInt(); 
                if (ans2 < 3 && ans2 > 0){  
                    Dispositive disp=new Thermostat(); 
                    for (Dispositive d : b.getDispositives()) {
                        
                        if (ans2 == checkType(d)){
                             disp = d; 
                        }                       
                    }
                    if (disp instanceof Thermostat  && ans == 4){
                        Thermostat thermostat = (Thermostat) disp;
                        thermostat.inspect(); 
                    }
                    switch (ans) {
                        case 1 -> System.out.println(disp.up() ? "The dispositive went up succesfully" : "It can't move further\n");
                        case 2 -> System.out.println(disp.down() ? "The dispositive went down succesfully" : "It can't move further\n");
                        case 3 -> disp.reset();
                        default -> System.out.println("You didn't type a number between 0-4, try again\n");
                    }
                                            
                    
                } else {
                    System.out.println("You didn't type a number between 1-3, try again\n");
                }
                
            }else {
                    System.out.println("You didn't type a number between 0-4, try again\n");
                }
        }
        
        
         
    }
    
    public static int checkType(Dispositive d){
        if (d instanceof Radio){
            return 1; 
        } else if (d instanceof Elevator){
            return 2; 
        } else if (d instanceof Thermostat){
            return 3; 
        }
        return 0; 
    }
}
    
