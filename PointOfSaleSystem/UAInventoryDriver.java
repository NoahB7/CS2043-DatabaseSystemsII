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
public class UAInventoryDriver implements UAInterface<UAInventory>{

    public ArrayList<UAInventory> getAll() {
        
        
        ArrayList<UAInventory> list = new ArrayList<>();
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT * FROM INVENTORY";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs != null){
                
                while(rs.next()){
                    
                    UAInventory inv = new UAInventory();
                    inv.setINV_ID(rs.getInt("INV_ID"));
                    inv.setINV_DESCRIPTION(rs.getString("INV_DESCRIPTION"));
                    inv.setINV_NAME(rs.getString("INV_NAME"));
                    inv.setINV_QTY_ONHAND(rs.getInt("INV_QTY_ONHAND"));
                    inv.setINV_REORDER_AMT(rs.getInt("INV_REORDER_AMT"));
                    inv.setINV_REORDER_PRICE(rs.getFloat("INV_REORDER_PRICE"));
                    list.add(inv);
                }
            }
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
        
        return list;
    }

    public boolean remove(UAInventory UA) {
        
        int INV_ID = UA.getINV_ID();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "DELETE FROM INVENTORY WHERE INV_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,INV_ID);
            
            pstmt.execute();
            
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
        
    }

    public boolean insert(UAInventory UA) {
        
        String INV_NAME = UA.getINV_NAME();
        String INV_DESCRIPTION = UA.getINV_DESCRIPTION();
        int INV_QTY_ONHAND = UA.getINV_QTY_ONHAND();
        int INV_REORDER_AMT = UA.getINV_REORDER_AMT();
        float INV_REORDER_PRICE = UA.getINV_REORDER_PRICE();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "INSERT INTO INVENTORY(INV_NAME, INV_DESCRIPTION, INV_QTY_ONHAND, INV_REORDER_AMT, INV_REORDER_PRICE)"
                    + "VALUES(?,?,?,?,?)";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, INV_NAME);
            pstmt.setString(2, INV_DESCRIPTION);
            pstmt.setInt(3, INV_QTY_ONHAND);
            pstmt.setInt(4, INV_REORDER_AMT);
            pstmt.setFloat(5, INV_REORDER_PRICE);
            
            pstmt.execute();
            
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        
        return true;
    }
    
    public boolean checkAvailableInventory(int INV_ID, int QUANTITY){
        
        boolean enoughInventory = false;
         try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT INV_QTY_ONHAND FROM INVENTORY WHERE INV_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,INV_ID);
            
            ResultSet rs = pstmt.executeQuery();
            if(rs != null){
                while(rs.next()){
                    if(QUANTITY <= rs.getInt("INV_QTY_ONHAND")){
                        enoughInventory = true;
                    }
                }
            }
            
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        
        return enoughInventory;
    }
    
    public void restock(int INV_ID){
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "UPDATE INVENTORY \n" +
                         "SET INV_QTY_ONHAND = (SELECT INV_QTY_ONHAND FROM INVENTORY WHERE INV_ID=?)+(SELECT INV_REORDER_AMT FROM INVENTORY WHERE INV_ID = ?)\n" +
                         "WHERE INV_ID  = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, INV_ID);
            pstmt.setInt(2, INV_ID);
            pstmt.setInt(3, INV_ID);
            
            pstmt.execute();
            
        } catch(Exception ex){
            ex.printStackTrace();
            return;
        }
    }
    
    public float restockPrice(ArrayList<Integer> IDs){
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            float sum = 0;
            for(int i = 0; i < IDs.size(); i++){
                String sql = "SELECT INV_REORDER_PRICE FROM INVENTORY WHERE INV_ID = ?";

                pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, IDs.get(i));

                ResultSet rs = pstmt.executeQuery();
                if(rs != null){
                    while(rs.next()){
                        sum += rs.getFloat("INV_REORDER_PRICE");
                    }
                }
            }
            return sum;
        } catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
    }
    
    public void updateInventory(int INV_ID, int QUANTITY){
        
         try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "UPDATE INVENTORY SET INV_QTY_ONHAND = (SELECT INV_QTY_ONHAND FROM INVENTORY WHERE INV_ID = ?) - ? WHERE INV_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,INV_ID);
            pstmt.setInt(2,QUANTITY);
            pstmt.setInt(3,INV_ID);
            
            pstmt.execute();
            
        } catch(Exception ex){
            ex.printStackTrace();
            return;
        }
    }
    
    public String getName(int ID){
         
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT INV_NAME FROM INVENTORY WHERE INV_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,ID);
            
            ResultSet rs = pstmt.executeQuery();
            String name = "";
            if(rs != null){
                
                while(rs.next()){
                    
                    name = rs.getString("INV_NAME");
                }
            }
            con.close();
            
            return name;
        } catch(Exception ex){
            ex.printStackTrace();
            return null;
        }
        
    }
    
    public int getReorderAmount(int ID){
         
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT INV_REORDER_AMT FROM INVENTORY WHERE INV_ID = ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,ID);
            
            ResultSet rs = pstmt.executeQuery();
            int amount = 0;
            if(rs != null){
                
                while(rs.next()){
                    
                    amount = rs.getInt("INV_REORDER_AMT");
                }
            }
            con.close();
            
            return amount;
        } catch(Exception ex){
            ex.printStackTrace();
            return 0;
        }
        
    }
    
}
