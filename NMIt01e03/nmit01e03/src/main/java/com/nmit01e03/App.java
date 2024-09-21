package com.nmit01e03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        ArrayList pList = new ArrayList<>(Arrays.asList
        (new Person("12345678B", "Ana", 18), 
        new Person("12345678A", "Ana", 30),
        new Person("23456789B", "Luis", 13), 
        new Person("34567890C", "Maria", 40),
        new Person("45678901D", "Juan", 35),
        new Person("56789012E", "Laura", 28), 
        new Person("67890123F", "Carlos", 50)));
        
        System.out.println(olderAge(pList));
        
        System.out.println(average(pList));
        
        System.out.println(olderName(pList));
        
        System.out.println(olderPerson(pList));
        
        System.out.println(legalAgeP(pList));
        
        System.out.println(otAverage(pList));
    }
    
    /*Optional method*/
    protected ArrayList<Person> createPersons(){
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> pList = new ArrayList<>(); 
        for (int i = 0; i < 6; i++) {
            System.out.println("Type person's dni: ");
            String dni = sc.next(); 
            System.out.println("Type person's name: ");
            String name = sc.next();
            System.out.println("Type person's age: ");
            int age = sc.nextInt();
            
            Person p = new Person(dni, name, age); 
            pList.add(p);   
        }
        return pList; 
    }
    
    protected static int olderAge(ArrayList<Person> pList){
        Person older = olderPerson(pList);
        return older.getAge(); 
    }
    
    protected static double average(ArrayList<Person> pList){
        double average = 0; 
        for (Person person : pList) {
            average += person.getAge(); 
        }
        average /= pList.size(); 
        return average; 
    }
    
    protected static String olderName(ArrayList<Person> pList){
        Person older = olderPerson(pList);
        return older.getName();
    }

    protected static Person olderPerson(ArrayList<Person> pList) {
        Person older = pList.get(0);
        for (Person person : pList) {
            if (person.getAge() > older.getAge()){
                older = person;
            }
        }
        return older; 
    }
    
    protected static ArrayList<Person> legalAgeP(ArrayList<Person> pList){
        int legalAge = 18; 
        ArrayList<Person> legalAgePeople = new ArrayList<>(); 
        for (Person person : pList) {
            if ((!legalAgePeople.contains(person)) && person.getAge() >= legalAge){
                legalAgePeople.add(person);
            }
        }
        return legalAgePeople; 
    }
    
    protected static ArrayList<Person> otAverage(ArrayList<Person> pList){
        double avge = average(pList);
        ArrayList<Person> oldtAverage = new ArrayList<>(); 
        for (Person person : pList) {
            if ((!oldtAverage.contains(person)) && person.getAge() >= avge){
                oldtAverage.add(person);
            }
        }
        return oldtAverage;
    }
}
