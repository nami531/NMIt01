/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nmit01e06;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author nadia
 */
public class Primitive {
    private int[] winnerComb; 

    public Primitive() {
        winnerComb = new int[6]; 
        Random r = new Random(); 
        for (int i = 0; i < winnerComb.length ; i++) {
            boolean next = false; 
            while (!next){
                int num = r.nextInt(1,50); 
                if (Arrays.binarySearch(winnerComb, num) < 0){
                    winnerComb[i] = num; 
                    next = true; 
                }
            }                              
        }
        Arrays.sort(winnerComb);
    }
    
    public int play(int[] comb){
        Arrays.sort(comb);
        if(Arrays.equals(comb, winnerComb)){
            return 6; 
        } else {
            int guessedNum = 0;
            for (int i = 0; i < comb.length; i++) {                 
                int winnerNum = winnerComb[i]; 
                for (int j = 0; j < comb.length; j++) {
                    if (winnerNum == comb[j]){
                        guessedNum++; 
                    }
                }     
            }
            return guessedNum; 
        }
        
    }

    public int[] getWinnerComb() {
        return winnerComb; 
    }/* This method is only for testing purposes*/
    
    
}
