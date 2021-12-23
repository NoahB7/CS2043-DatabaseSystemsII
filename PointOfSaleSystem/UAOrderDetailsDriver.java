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
public class UAOrderDetailsDriver implements UAInterface<UAOrderDetails>{

    public boolean insert(UAOrderDetails UA) {
        
        int ORDER_ID = UA.getORDER_ID();
        int BAKERY_ITEM_ID = UA.getBAKERY_ITEM_ID();
        int QUANTITY = UA.getQUANTITY();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "INSERT INTO ORDER_DETAILS(ORDER_ID, BAKERY_ITEM_ID, QUANTITY)"
                    + "VALUES(?,?,?)";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, ORDER_ID);
            pstmt.setInt(2, BAKERY_ITEM_ID);
            pstmt.setInt(3, QUANTITY);
            
            pstmt.execute();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean remove(UAOrderDetails UA) {
        
        int ORDER_DETAILS_ID = UA.getORDER_DETAILS_ID();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "DELETE FROM ORDERS_DETAILS WHERE ORDER_DETAILS_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,ORDER_DETAILS_ID);
            
            pstmt.execute();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }

    public ArrayList<UAOrderDetails> getAll() {
        
        
         ArrayList<UAOrderDetails> list = new ArrayList<>();
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT * FROM ORDER_DETAILS";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    
                    UAOrderDetails orderDetails = new UAOrderDetails();
                    orderDetails.setBAKERY_ITEM_ID(rs.getInt("BAKERY_ITEM_ID"));
                    orderDetails.setORDER_DETAILS_ID(rs.getInt("ORDER_DETAILS_ID"));
                    orderDetails.setORDER_ID(rs.getInt("ORDER_ID"));
                    orderDetails.setQUANTITY(rs.getInt("QUANTITY"));
                    list.add(orderDetails);
                }
            }
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
        return list;
    }
    
    public int getID(){
        
        int val = 0;
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT MAX(ORDER_ID) FROM ORDERS";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    val = rs.getInt(1);
                }
            }
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
        return val;
    }
    
    public ArrayList<CompleteOrder> getAllOrdersByCust(String name){
        
        String first = "%"+name.split(" ")[0]+"%";
        String last = "%"+name.split(" ")[1]+"%";
        ArrayList<CompleteOrder> list = new ArrayList<>();
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT O.ORDER_ID, ORDER_DETAILS_ID, BAKERY_ITEM_ID, QUANTITY, ORDER_TIME, ORDER_DATE\n" +
                         "FROM ORDERS O\n" +
                         "JOIN ORDER_DETAILS OD\n" +
                         "ON O.ORDER_ID = OD.ORDER_ID\n" +
                         "WHERE CUSTOMERS_CUST_ID = (SELECT CUST_ID FROM CUSTOMERS WHERE CUST_FIRST_NAME LIKE ? OR CUST_LAST_NAME LIKE ?) \n";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, first);
            pstmt.setString(2, last);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    CompleteOrder order = new CompleteOrder();
                    order.setORDER_ID(rs.getInt("ORDER_ID"));
                    order.setORDER_DETAILS_ID(rs.getInt("ORDER_DETAILS_ID"));
                    order.setBAKERY_ITEM_ID(rs.getInt("BAKERY_ITEM_ID"));
                    order.setQUANTITY(rs.getInt("QUANTITY"));
                    order.setORDER_TIME(rs.getString("ORDER_TIME"));
                    order.setORDER_DATE(rs.getString("ORDER_DATE"));
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
    
    public ArrayList<CompleteOrder> getSpecificOrderByCust(String name, int id){
        
        String first = "%"+name.split(" ")[0]+"%";
        String last = "%"+name.split(" ")[1]+"%";
        ArrayList<CompleteOrder> list = new ArrayList<>();
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT O.ORDER_ID, ORDER_DETAILS_ID, BAKERY_ITEM_ID, QUANTITY, ORDER_TIME, ORDER_DATE\n" +
                         "FROM ORDERS O\n" +
                         "JOIN ORDER_DETAILS OD\n" +
                         "ON O.ORDER_ID = OD.ORDER_ID\n" +
                         "WHERE CUSTOMERS_CUST_ID = (SELECT CUST_ID FROM CUSTOMERS WHERE CUST_FIRST_NAME LIKE ? OR CUST_LAST_NAME LIKE ?) \n" +
                         "AND O.ORDER_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, first);
            pstmt.setString(2, last);
            pstmt.setInt(3, id);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    CompleteOrder order = new CompleteOrder();
                    order.setORDER_ID(rs.getInt("ORDER_ID"));
                    order.setORDER_DETAILS_ID(rs.getInt("ORDER_DETAILS_ID"));
                    order.setBAKERY_ITEM_ID(rs.getInt("BAKERY_ITEM_ID"));
                    order.setQUANTITY(rs.getInt("QUANTITY"));
                    order.setORDER_TIME(rs.getString("ORDER_TIME"));
                    order.setORDER_DATE(rs.getString("ORDER_DATE"));
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
