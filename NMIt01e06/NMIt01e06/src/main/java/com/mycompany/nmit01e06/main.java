/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nmit01e06;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nadia
 */

public class main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        Primitive p = new Primitive();
        System.out.println(Arrays.toString(p.getWinnerComb()));
        
        System.out.println("WELCOME TO THE PRIMITIVE LOTTERY PROGRAM!");
        
        int[] playNum = new int[6]; 
        for (int i = 0; i < playNum.length; i++) {
            boolean next = false; 
            System.out.println("Introduce your " + (i+1) + " number: " );
          
            String numStr =  sc.nextLine().trim();
            int num=0; 
            while (!next){
                if (numStr.matches("\\d+") ){
                    num =  Integer.parseInt(numStr);

                        /*It returns true when: The introduced number is between 1-49 both included,
                          if the array doesn't contain the introduced number*/
                        if ((num <= 49 && num >= 1) && (!isDuplicated(playNum, num, i))){
                            playNum[i] = num; 
                            next= true; 
                        } else {
                            System.out.println("Sorry we didn't understand you, type a number between 1-49 again, please"); 
                            numStr =  sc.nextLine().trim();
                            if (numStr.matches("\\d+")){
                                num = Integer.parseInt(numStr);
                            }

                        }
                } else {
                    System.out.println("Type a number between 1-49, please");
                    numStr =  sc.nextLine().trim();
                    if (numStr.matches("\\d+")){
                        num = Integer.parseInt(numStr);
                        
                }
            }
            
        }
}
        int checkResult = p.play(playNum); 
        System.out.println("-------We are going to check the results....-------");
        if (checkResult == 6){
            System.out.println("You have got " + checkResult  + " numbers right, CONGRATULATIONS YOU WON THE LOTTERY!!!!!!!!!!!!");
        } else {
            System.out.println("You have got " + checkResult  + " numbers right, maybe next time");        
        }              
    }
    

    

    private static boolean isDuplicated(int[] array, int num, int currentIndex) {
        for (int i = 0; i < currentIndex; i++) {
            if (array[i] == num) {
                return true;  // The number is already in the array
            }
        }
        return false;  // No duplicate found
    }
}