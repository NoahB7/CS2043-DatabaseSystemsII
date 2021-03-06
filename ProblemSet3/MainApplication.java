/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.Calendar;

/************************************************************
* name Noah Buchanan
* user ua100
* date 5 February 2021
* assign Problem Set 3
************************************************************/

/**
 *
 * @author noah_
 */
public class MainApplication extends javax.swing.JFrame {

    public static int SEARCH_ID_NUM = 1;
    DefaultTableModel model2 = new DefaultTableModel();
    /**
     * Creates new form MainApplication
     */
    public MainApplication() {
        initComponents();
        
        model2.addColumn("SEARCH_ID");
        model2.addColumn("SEARCH_TEXT");
        model2.addColumn("SEARCH_TIME");
        TABLE2.setModel(model2);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        inputText = new javax.swing.JTextField();
        button = new javax.swing.JButton();
        SEARCH_HISTORY = new javax.swing.JTabbedPane();
        panel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TABLE = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        TABLE2 = new javax.swing.JTable();
        clearHistory = new javax.swing.JButton();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(table);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputText.setText("enter search...");
        inputText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTextActionPerformed(evt);
            }
        });

        button.setText("search");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(TABLE);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
        );

        SEARCH_HISTORY.addTab("Database Search", panel1);

        TABLE2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "SEARCH_ID", "SEARCH_TEXT", "SEARCH_TIME"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane6.setViewportView(TABLE2);

        SEARCH_HISTORY.addTab("Search History", jScrollPane6);

        clearHistory.setText("clear history");
        clearHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearHistoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SEARCH_HISTORY, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(132, 132, 132)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(clearHistory, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(clearHistory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(button, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addComponent(SEARCH_HISTORY, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Name");
        model.addColumn("Associated ID");
        TABLE.setModel(model);
        String input = inputText.getText();
        input = input.toLowerCase();
        String search_txt = input;
        String[] row2 = new String[3];
        row2[1] = "'" + input + "'";
        input = "%"+input+"%";
        
        try{
            Class.forName("com.ibm.db2.jcc.DB2Driver");
            
            Connection con;
            PreparedStatement pstmt;
            
            String dbuser = "ua100";
            String dbpass = "UApass7402";
            String dburl = "jdbc:db2://data.cis.uafs.edu:55000/CS2043";
            
            String sql = "SELECT USERNAME,USERID\n" +
"FROM USER\n" +
"WHERE USERNAME LIKE ?\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT ALBUMNAME,USERID\n" +
"FROM ALBUM\n" +
"WHERE ALBUMNAME LIKE ?\n" +
"\n" +
"UNION ALL \n" +
"\n" +
"SELECT GROUPNAME,GROUPID\n" +
"FROM GROUP\n" +
"WHERE GROUPNAME LIKE ?\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT MESSAGECONTENT,MESSAGEID\n" +
"FROM MESSAGE\n" +
"WHERE MESSAGECONTENT LIKE ?\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT PICTURENAME,PICTUREID\n" +
"FROM PICTURE\n" +
"WHERE PICTURENAME LIKE ?\n" +
"\n" +
"UNION ALL\n" +
"\n" +
"SELECT COMMENTCONTENT,COMMENTID\n" +
"FROM COMMENT\n" +
"WHERE COMMENTCONTENT LIKE ?";
            
            con = DriverManager.getConnection(dburl,dbuser,dbpass);
            
            pstmt = con.prepareStatement(sql);
            for(int i =1; i < 7; i++){
                
                pstmt.setString(i,input);
            }
            
            ResultSet data = pstmt.executeQuery();
            Calendar cal = Calendar.getInstance();
            
            row2[0] = SEARCH_ID_NUM +"";
            row2[2] = new SimpleDateFormat("EEEE, MMMM dd, yyyy 'at' HH:mm a").format(Calendar.getInstance().getTime());
            model2.addRow(row2);
            if(data != null){
                while(data.next()){
                    String[] row = new String[2];
                    row[0] = data.getString(1);
                    row[1] = data.getString(2);
                    model.addRow(row);
                    
                }
            }
            
            sql = "INSERT INTO SEARCH_HISTORY(SEARCH_ID,SEARCH_TXT,SEARCH_TIME)\n" +
"VALUES(?, ?, ?)";
            System.out.println(SEARCH_ID_NUM);
            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, SEARCH_ID_NUM);
            pstmt.setString(2, search_txt);
            pstmt.setString(3, new SimpleDateFormat("yyyy-mm-dd").format(Calendar.getInstance().getTime()));
            pstmt.execute();
            
            
            SEARCH_ID_NUM++;
            con.close();
                                    
        } catch(Exception ex){
            ex.printStackTrace();
            return;
        }
    }                                      

    private void inputTextActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void clearHistoryActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        model2.setRowCount(0);
    }                                            

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainApplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainApplication().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTabbedPane SEARCH_HISTORY;
    private javax.swing.JTable TABLE;
    private javax.swing.JTable TABLE2;
    private javax.swing.JButton button;
    private javax.swing.JButton clearHistory;
    private javax.swing.JTextField inputText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JPanel panel1;
    private javax.swing.JTable table;
    // End of variables declaration                   
}
