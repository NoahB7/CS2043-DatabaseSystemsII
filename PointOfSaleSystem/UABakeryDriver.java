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
public class UABakeryDriver implements UAInterface<UABakery>{

    public ArrayList<UABakery> getAll() {
        
        
        ArrayList<UABakery> list = new ArrayList<>();
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT * FROM BAKERY_ITEMS";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    
                    UABakery bak = new UABakery();
                    bak.setBAKERY_ITEM_ID(rs.getInt("BAKERY_ITEM_ID"));
                    bak.setBAKERY_ITEM_DESCRIPTION(rs.getString("BAKERY_ITEM_DESCRIPTION"));
                    bak.setBAKERY_ITEM_NAME(rs.getString("BAKERY_ITEM_NAME"));
                    bak.setBAKERY_ITEM_PRICE(rs.getFloat("BAKERY_ITEM_PRICE"));
                    list.add(bak);
                }
            }
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
        
        return list;
    }

    public boolean remove(UABakery UA) {
        
        int BAKERY_ITEM_ID = UA.getBAKERY_ITEM_ID();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "DELETE FROM BAKERY_ITEMS WHERE BAKERY_ITEM_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,BAKERY_ITEM_ID);
            
            pstmt.execute();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insert(UABakery UA) {
        
        String BAKERY_ITEM_NAME = UA.getBAKERY_ITEM_NAME();
        String BAKERY_ITEM_DESCRIPTION = UA.getBAKERY_ITEM_DESCRIPTION();
        float BAKERY_ITEM_PRICE = UA.getBAKERY_ITEM_PRICE();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "INSERT INTO BAKERY_ITEMS(BAKERY_ITEM_NAME, BAKERY_ITEM_DESCRIPTION, BAKERY_ITEM_PRICE)"
                    + "VALUES(?,?,?)";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, BAKERY_ITEM_NAME);
            pstmt.setString(2, BAKERY_ITEM_DESCRIPTION);
            pstmt.setFloat(3, BAKERY_ITEM_PRICE);
            
            pstmt.execute();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public String getName(int ID){
         
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT BAKERY_ITEM_NAME FROM BAKERY_ITEMS WHERE BAKERY_ITEM_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,ID);
            
            ResultSet rs = pstmt.executeQuery();
            String name = "";
            if(rs != null){
                
                while(rs.next()){
                    
                    name = rs.getString("BAKERY_ITEM_NAME");
                }
            }
            con.close();
            
            return name;
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
    }
    
}
