/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.nmit01e08;

import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author nadia
 */
public interface DAOInterface {
    public boolean createWorker(Worker w)throws SQLException; 
    public boolean deleteWorker(Worker w) throws SQLException; 
    public boolean updateWorker(Worker w, String newName, double newSalary) throws SQLException; 
    public void readBwnSalary(double min , double max) throws SQLException; 
    public boolean initialLoad(ArrayList<String[]> workersList) throws SQLException; 
}
