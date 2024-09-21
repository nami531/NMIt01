/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.nmit01e08;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nadia
 */
public class NMIt01e08 {

    public static void main(String[] args) throws IOException, SQLException {
        Scanner sc = new Scanner(System.in);
        DAO d = new DAO("jdbc:mysql://localhost:3306/work", "root", "password"); 
        ArrayList<String[]> list = d.generateData(); 
        d.initialLoad(list); 
        ArrayList<Worker> workersList = generateListWorker(list); 
        System.out.println(workersList);
        System.out.println("""
                           Welcome to the worker's data manager program
                           What do you want to do?: 
                           1.Register an employer
                           2.Fire an employer
                           3.Update an employer's data
                           4.Check employer's data
                           """);        
        int ans= sc.nextInt(); 
        switch (ans) {
            case 1 ->                 {
                    System.out.println("Introduce his/her name: ");
                    String name = sc.nextLine();
                    System.out.println("Type his/her id: ");
                    Long id = sc.nextLong();
                    System.out.println("Type his/her salary: ");
                    Double salary = sc.nextDouble();
                    Worker w = new Worker(id, name, salary);
                    d.createWorker(w);
                }
            case 2 ->                 {
                    System.out.println("Type his/her id: ");
                    Long id = sc.nextLong();
                    Worker w =findWorker(workersList, id)  ;
                    if (w != null){
                        d.deleteWorker(w);
                        for (Worker worker : workersList) {
                            if (worker.getId() == id){
                                workersList.remove(worker);
                            }
                        }
                    }                      }
            case 3 -> {
                    System.out.println("Type his/her id: ");
                    Long id = sc.nextLong();
                    System.out.println("Introduce his/her new name: ");
                    String name = sc.nextLine();
                    System.out.println("Type his/her salary: ");
                    Double salary = sc.nextDouble();
                    Worker w =findWorker(workersList, id)  ;
                    if (w != null){
                        w.setName(name);
                        w.setSalary(salary);
                        d.updateWorker(w, name, salary); 
                    } 
            }
            case 4 -> {
                    System.out.println("Type minimun salary");
                    double min = sc.nextDouble(); 
                    System.out.println("Type maximun salary");
                    double max  = sc.nextDouble(); 
                    d.readBwnSalary(min, max);
            }
            default -> {
                System.out.println("Sorry, I think you typed a wrong number, please introduce a number between 1-4");
            }
        }
    }

    public static Worker findWorker(ArrayList<Worker> workersList, Long id) {
        for (Worker worker : workersList) {
            if (worker.getId() == id) {
                return worker;
            }
        }
        return null;
    }
    
    public static ArrayList<Worker> generateListWorker(ArrayList<String[]> list){
        ArrayList<Worker> workers = new ArrayList<>(); 
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i)[0];
            long id = Long.parseLong(list.get(i)[1]);
            double salary = Double.parseDouble(list.get(i)[2]);
            Worker w = new Worker(id, name, salary);  
            workers.add(w); 
        }
        return workers;
    }
}
