/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uabakerysystem_nbuchanan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author noah_
 */
public class UAOrderDriver implements UAInterface<UAOrder>{

    public boolean insert(UAOrder UA) {
        
        String ORDER_DATE = UA.getORDER_DATE();
        String ORDER_TIME = UA.getORDER_TIME();
        int CUSTOMERS_CUST_ID = UA.getCUSTOMERS_CUST_ID();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "INSERT INTO ORDERS(ORDER_DATE, ORDER_TIME, CUSTOMERS_CUST_ID)"
                    + "VALUES(?,?,?)";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ORDER_DATE);
            pstmt.setString(2, ORDER_TIME);
            pstmt.setInt(3, CUSTOMERS_CUST_ID);
            
            pstmt.execute();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean remove(UAOrder UA) {
        
        int ORDER_ID = UA.getORDER_ID();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "DELETE FROM ORDERS WHERE ORDER_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,ORDER_ID);
            
            pstmt.execute();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }

    public ArrayList<UAOrder> getAll() {
        
         ArrayList<UAOrder> list = new ArrayList<>();
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT * FROM ORDERS";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    
                    UAOrder order = new UAOrder();
                    order.setORDER_ID(rs.getInt("ORDER_ID"));
                    order.setCUSTOMERS_CUST_ID(rs.getInt("CUSTOMERS_CUST_ID"));
                    order.setORDER_DATE(rs.getString("ORDER_DATE"));
                    order.setORDER_TIME(rs.getString("ORDER_TIME"));
                    list.add(order);
                }
            }
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
        
        return list;
    }
    
}
