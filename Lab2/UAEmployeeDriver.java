/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2lab2_nbuchanan;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author noah_
 */
public class UAEmployeeDriver implements UADataInterface1{

    public ArrayList<UAEmployee> getAllItems() {
        
        ArrayList<UAEmployee> list = new ArrayList<>();
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT * FROM EMPLOYEES";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    
                    UAEmployee emp = new UAEmployee();
                    emp.setID(rs.getInt("EMP_ID"));
                    emp.setFirstName(rs.getString("EMP_FIRST_NAME"));
                    emp.setLastName(rs.getString("EMP_LAST_NAME"));
                    emp.setEmail(rs.getString("EMP_EMAIL"));
                    list.add(emp);
                    
                }
            }
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
        
        return list;
    }

    @Override
    public void insert(String firstName, String lastName, String email) {
        
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "INSERT INTO EMPLOYEES(EMP_FIRST_NAME,EMP_LAST_NAME,EMP_EMAIL) VALUES(?,?,?)";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1,firstName);
            pstmt.setString(2,lastName);
            pstmt.setString(3,email);
            pstmt.execute();
            
            
        } catch(Exception ex){
            ex.printStackTrace();
            return;
        }
        
    }
    
}
