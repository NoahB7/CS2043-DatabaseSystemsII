/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2lab2_nbuchanan;

import java.util.ArrayList;

/**
 *
 * @author noah_
 */
public interface UADataInterface1 {
    
    ArrayList<UAEmployee> getAllItems();
    void insert(String firstName, String lastName, String email);
    
}
