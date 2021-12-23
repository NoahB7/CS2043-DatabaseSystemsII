/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uabakerysystem_nbuchanan;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author noah_
 */
public class UACustomerDriver implements UAInterface<UACustomer> {

    public ArrayList<UACustomer> getAll() {
        
        ArrayList<UACustomer> list = new ArrayList<>();
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT * FROM CUSTOMERS";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    
                    UACustomer cust = new UACustomer();
                    cust.setCUST_ID(rs.getInt("CUST_ID"));
                    cust.setCUST_FIRST_NAME(rs.getString("CUST_FIRST_NAME"));
                    cust.setCUST_LAST_NAME(rs.getString("CUST_LAST_NAME"));
                    cust.setCUST_ADDRESS(rs.getString("CUST_ADDRESS"));
                    cust.setCUST_CITY(rs.getString("CUST_CITY"));
                    cust.setCUST_STATE(rs.getString("CUST_STATE"));
                    cust.setCUST_ZIP(rs.getString("CUST_ZIP"));
                    cust.setCUST_PHONE(rs.getString("CUST_PHONE"));
                    cust.setCUST_EMAIL(rs.getString("CUST_EMAIL"));
                    cust.setCUST_USERNAME(rs.getString("CUST_USERNAME"));
                    cust.setCUST_PASSWORD(rs.getString("CUST_PASSWORD"));
                    list.add(cust);
                }
            }
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
        
        return list;
    }

    public boolean remove(UACustomer UA) {
                
        int CUST_ID = UA.getCUST_ID();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "DELETE FROM CUSTOMERS WHERE CUST_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,CUST_ID);
            
            pstmt.execute();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
        
    }

    public boolean insert(UACustomer UA) {
        
        String CUST_FIRST_NAME = UA.getCUST_FIRST_NAME();
        String CUST_LAST_NAME = UA.getCUST_LAST_NAME();
        String CUST_ADDRESS = UA.getCUST_ADDRESS();
        String CUST_CITY = UA.getCUST_CITY();
        String CUST_STATE = UA.getCUST_STATE();
        String CUST_ZIP = UA.getCUST_ZIP();
        String CUST_PHONE = UA.getCUST_PHONE();
        String CUST_EMAIL = UA.getCUST_EMAIL();
        String CUST_USERNAME = UA.getCUST_USERNAME();
        String CUST_PASSWORD = UA.getCUST_PASSWORD();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "INSERT INTO CUSTOMERS(CUST_FIRST_NAME, CUST_LAST_NAME, CUST_ADDRESS, CUST_CITY, CUST_STATE, CUST_ZIP, CUST_PHONE, CUST_EMAIL, CUST_USERNAME, CUST_PASSWORD)"
                    + "VALUES(?,?,?,?,?,?,?,?,?,?)";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, CUST_FIRST_NAME);
            pstmt.setString(2, CUST_LAST_NAME);
            pstmt.setString(3, CUST_ADDRESS);
            pstmt.setString(4, CUST_CITY);
            pstmt.setString(5, CUST_STATE);
            pstmt.setString(6, CUST_ZIP);
            pstmt.setString(7, CUST_PHONE);
            pstmt.setString(8, CUST_EMAIL);
            pstmt.setString(9, CUST_USERNAME);
            pstmt.setString(10, CUST_PASSWORD);
            
            pstmt.execute();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
}
