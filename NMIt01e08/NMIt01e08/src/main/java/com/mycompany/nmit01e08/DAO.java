/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.nmit01e08;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author nadia
 */
public class DAO implements DAOInterface{
    private String url;
    private String user; 
    private String password; 

    public DAO(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    public DAO(String url, String user) {
        this.url = url;
        this.user = user;
        this.password = ""; 
    }

    @Override
    public boolean createWorker(Worker w) throws SQLException {
        String sentence = "INSERT INTO WORKER(name, id, salary) VALUES (? , ? , ?);";
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            try (PreparedStatement sentenceTable = connection.prepareStatement(sentence)){
                sentenceTable.setString(1,w.getName());
                sentenceTable.setLong(2, w.getId()); 
                sentenceTable.setDouble(3, w.getSalary()); 
                
                int affectedRows = sentenceTable.executeUpdate(); 
                return affectedRows > 0 ; 
            }
            
        }
    }

    @Override
    public boolean deleteWorker(Worker w) throws SQLException {
        String sentence = "DELETE FROM WORKER WHERE ID=?; "; 
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            try (PreparedStatement sentenceTable = connection.prepareStatement(sentence)){
                sentenceTable.setLong(1,w.getId()); 
                
                int affectedRows = sentenceTable.executeUpdate(); 
                return affectedRows > 0 ; 
            }
            
        }
    }

    @Override
    public boolean updateWorker(Worker w, String newName, double newSalary) throws SQLException {
        String sentence = "UPDATE WORKER SET NAME=?, SALARY=? WHERE id=?"; 
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            try (PreparedStatement sentenceTable = connection.prepareStatement(sentence)){
                sentenceTable.setString(1,newName); 
                sentenceTable.setDouble(2, newSalary); 
                sentenceTable.setDouble(3, w.getId()); 
                                
                int affectedRows = sentenceTable.executeUpdate(); 
                return affectedRows > 0 ; 
            }
            
        }
    }

    @Override
    public void readBwnSalary(double min , double max) throws SQLException {
        String sentence = "SELECT FROM WORKER WHERE salary > ? && salary < ? "; 
        try(Connection connection = DriverManager.getConnection(url, user, password)){
            try (PreparedStatement sentenceTable = connection.prepareStatement(sentence)){
                sentenceTable.setDouble(1, min); 
                sentenceTable.setDouble(2, max); 
                                
                ResultSet result = sentenceTable.executeQuery(); 
                while (result.next()){
                    Worker w = new Worker(result.getString("name"), result.getDouble("salary"));
                    System.out.println(w);
                }
            }
            
        }
    }

    @Override
    public boolean initialLoad(ArrayList<String[]> workersList) throws SQLException {
        String sentence  = "INSERT INTO WORKER(name, id, salary) VALUES (? , ? , ? );";
        try (Connection connection = DriverManager.getConnection(url, user, password)){
            connection.setAutoCommit(false);
            try (PreparedStatement sentenceTable = connection.prepareStatement(sentence)){
                for (int i = 0; i < workersList.size(); i++) {
                    sentenceTable.setString(1, workersList.get(i)[0]);
                    sentenceTable.setLong(2, Long.parseLong(workersList.get(i)[1])); 
                    sentenceTable.setLong(3, Long.parseLong(workersList.get(i)[2]));
                    
                }
                    int affectedRows = sentenceTable.executeUpdate(); 
                    return affectedRows == workersList.size();
            }
        }
    }
    
    public ArrayList<String[]> generateData() throws IOException{
        String path = "./workers.csv"; 
        File f =new File(path); 
        String data ; 
        ArrayList<String[]> workers = new ArrayList<>() ;
        try ( FileInputStream fis = new FileInputStream(f); 
                InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
                BufferedReader bfr = new BufferedReader(isr); ){
             
            while ( (data = bfr.readLine())!= null ){
                String[] worker = data.split(","); 
                if (!workers.contains(worker)){
                    workers.add(worker); 
                }
                
            }
            System.out.println(workers);
        } catch (FileNotFoundException ex) {
            System.err.printf("Error:%s\n", ex.getMessage());
        } 
        return workers;
    
}
}
