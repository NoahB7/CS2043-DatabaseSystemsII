/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uabakerysystem_nbuchanan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 *
 * @author noah_
 */
public class UARecipeDriver implements UAInterface<UARecipe>{

    public boolean insert(UARecipe UA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean remove(UARecipe UA) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<UARecipe> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<int []> getIngredients(int BAKERY_ITEM_ID){
                
        ArrayList<int []> list = new ArrayList<>();
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT INV_ID, SUM(INV_QTY_NEEDED) AS \"QUANTITY\" FROM RECIPE WHERE BAKERY_ITEM_ID = ? GROUP BY INV_ID";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1,BAKERY_ITEM_ID);
            
            ResultSet rs = pstmt.executeQuery();
            int i = 0;
            if(rs != null){
                while(rs.next()){
                    list.add(new int[2]);
                    list.get(i)[0] = rs.getInt("INV_ID");
                    list.get(i)[1] = rs.getInt("QUANTITY");
                    i++;
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
