/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nmit01e07;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author nadia
 */
public class NMIt01e07 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in); 
        System.out.println("Type a text line here: ");
        String str = sc.nextLine(); 
        
        char[] strArray = str.toCharArray(); 
        Arrays.sort(strArray); 
        
        HashMap<Character, Integer> occurrences = new HashMap<>(); 
        
        for (int i = 0; i < strArray.length; i++) {
            char c = (Character) strArray[i];
            if (!occurrences.containsKey(c)){
                occurrences.put(c,  1);
            } else {
                int count = occurrences.get(c);
                occurrences.put(c, count + 1); 
            }
            
        }
        
        System.out.println(occurrences);
    }
}
