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
public class TransactionJournalDriver implements UAInterface<TransactionJournal>{

    public ArrayList<TransactionJournal> getAll() {
        return null;
    }

    public boolean remove(TransactionJournal UA) {
        return false;
    }

    public boolean insert(TransactionJournal UA) {
        
        String JOURNAL_DESCRIPTION = UA.getJOURNAL_DESCRIPTION();
        float JOURNAL_AMOUNT = UA.getJOURNAL_AMOUNT();
        String JOURNAL_TIME = UA.getJOURNAL_TIME();
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "INSERT INTO TRANSACTION_JOURNAL(JOURNAL_DESCRIPTION, JOURNAL_AMOUNT, JOURNAL_TIME)\n" +
"VALUES(?,?,?)";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, JOURNAL_DESCRIPTION);
            pstmt.setFloat(2, JOURNAL_AMOUNT);
            pstmt.setString(3, JOURNAL_TIME);
            
            pstmt.execute();
            con.close();
        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public float getJournalAmount(){
        
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
        
            String sql = "SELECT JOURNAL_AMOUNT FROM TRANSACTION_JOURNAL WHERE JOURNAL_ID = (SELECT MAX(JOURNAL_ID) FROM TRANSACTION_JOURNAL)";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            
            ResultSet rs = pstmt.executeQuery();
            float amount = 0;
            if(rs != null){
                while(rs.next()){
                    amount = rs.getFloat("JOURNAL_AMOUNT");
                }
            }
            
            con.close();
            
            return amount;
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return 0;
    }
    
}
