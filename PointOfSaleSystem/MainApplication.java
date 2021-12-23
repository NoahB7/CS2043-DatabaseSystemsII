/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uabakerysystem_nbuchanan;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/************************************************************
* name Noah Buchanan
* user ua100
* date 11 April 2021
* assign Problem Set 6
************************************************************/


/**
 *
 * @author noah_
 */
public class MainApplication extends javax.swing.JFrame {
    
/************************************************************
* name Noah Buchanan
* user ua100
* date 15 February 2021
* assign Problem Set 5
************************************************************/
    
    DefaultTableModel customerModel = new DefaultTableModel();
    DefaultTableModel inventoryModel = new DefaultTableModel();
    DefaultTableModel bakeryModel = new DefaultTableModel();
    DefaultTableModel ordersModel = new DefaultTableModel();
    DefaultTableModel orderDetailsModel = new DefaultTableModel();
    DefaultTableModel cartModel = new DefaultTableModel();
    DefaultTableModel availableItemsModel = new DefaultTableModel();
    DefaultTableModel availableCustomersModel = new DefaultTableModel();
    DefaultTableModel customerSearchModel = new DefaultTableModel();
    

    /**
     * Creates new form MainApplication
     */
    public MainApplication() {
        initComponents();
        
        {
            cartModel = new DefaultTableModel();
            cartModel.addColumn("Customer ID");
            
        }
        
        {
            inventoryModel = new DefaultTableModel();
            inventoryModel.addColumn("Inventory ID");
            inventoryModel.addColumn("Inventory Name");
            inventoryModel.addColumn("Inventory Description");
            inventoryModel.addColumn("Quantity");
            inventoryModel.addColumn("Reorder Amount");
            inventoryModel.addColumn("Reorder Price");
            InventoryTable.setModel(inventoryModel);

            UAInventoryDriver x = new UAInventoryDriver();

            ArrayList<UAInventory> list = x.getAll();
            for(int i = 0; i < list.size(); i++){
                String[] row = new String[6];
                row[0] = list.get(i).getINV_ID()+"";
                row[1] = list.get(i).getINV_NAME();
                row[2] = list.get(i).getINV_DESCRIPTION();
                row[3] = list.get(i).getINV_QTY_ONHAND()+"";
                row[4] = list.get(i).getINV_REORDER_AMT()+"";
                row[5] = list.get(i).getINV_REORDER_PRICE()+"";
                inventoryModel.addRow(row);
            }
        }
        
           
          
        {
            bakeryModel = new DefaultTableModel();
            bakeryModel.addColumn("Item ID");
            bakeryModel.addColumn("Item Name");
            bakeryModel.addColumn("Item Description");
            bakeryModel.addColumn("Item Price");
            ItemTable.setModel(bakeryModel);

            UABakeryDriver x = new UABakeryDriver();

            ArrayList<UABakery> list = x.getAll();
            for(int i = 0; i < list.size(); i++){
                String[] row = new String[4];
                row[0] = list.get(i).getBAKERY_ITEM_ID()+"";
                row[1] = list.get(i).getBAKERY_ITEM_NAME();
                row[2] = list.get(i).getBAKERY_ITEM_DESCRIPTION();
                row[3] = list.get(i).getBAKERY_ITEM_PRICE()+"";
                bakeryModel.addRow(row);
            }
        }
        
        {
            customerModel = new DefaultTableModel();
            customerModel.addColumn("Customer ID");
            customerModel.addColumn("Customer Name");
            customerModel.addColumn("Customer Phone");
            customerModel.addColumn("Customer Email");
            customerModel.addColumn("Customer Username");
            customerModel.addColumn("Customer Password");
            customerModel.addColumn("Customer Address");
            CustomerTable.setModel(customerModel);

            UACustomerDriver x = new UACustomerDriver();

            ArrayList<UACustomer> list = x.getAll();
            for(int i = 0; i < list.size(); i++){
                String[] row = new String[7];
                row[0] = list.get(i).getCUST_ID() + "";
                row[1] = list.get(i).getCUST_FIRST_NAME() + " " + list.get(i).getCUST_LAST_NAME();
                row[2] = list.get(i).getCUST_PHONE();
                row[3] = list.get(i).getCUST_EMAIL();
                row[4] = list.get(i).getCUST_USERNAME();
                row[5] = "*hidden*";
                row[6] = list.get(i).getCUST_CITY() + ", " + list.get(i).getCUST_STATE() + ", " + list.get(i).getCUST_ZIP();
                customerModel.addRow(row);
            }
        }
        
        {  

            orderDetailsModel = new DefaultTableModel();
            orderDetailsModel.addColumn("Order Details ID");
            orderDetailsModel.addColumn("Associated Order ID");
            orderDetailsModel.addColumn("Bakery Item ID");
            orderDetailsModel.addColumn("Quantity");
            OrderDetailsTable.setModel(orderDetailsModel);

            UAOrderDetailsDriver x = new UAOrderDetailsDriver();
            ArrayList<UAOrderDetails> list = x.getAll();

            for(int i = 0; i < list.size(); i++){
                String[] row = new String[4];
                row[0] = list.get(i).getORDER_DETAILS_ID()+"";
                row[1] = list.get(i).getORDER_ID()+"";
                row[2] = list.get(i).getBAKERY_ITEM_ID()+"";
                row[3] = list.get(i).getQUANTITY()+"";
                orderDetailsModel.addRow(row);
            }
        }
        
        {
            ordersModel = new DefaultTableModel();
            ordersModel.addColumn("Order ID");
            ordersModel.addColumn("Order Date");
            ordersModel.addColumn("Order Time");
            ordersModel.addColumn("Customer ID");
            OrdersTable.setModel(ordersModel);

            UAOrderDriver x = new UAOrderDriver();
            ArrayList<UAOrder> list = x.getAll();

            for(int i = 0; i < list.size(); i++){
                String[] row = new String[4];
                row[0] = list.get(i).getORDER_ID()+"";
                row[1] = list.get(i).getORDER_DATE();
                row[2] = list.get(i).getORDER_TIME();
                row[3] = list.get(i).getCUSTOMERS_CUST_ID()+"";
                ordersModel.addRow(row);
            }
        }
        
        {
            availableItemsModel = new DefaultTableModel();
            availableItemsModel.addColumn("Item ID");
            availableItemsModel.addColumn("Item Name");
            availableItemsModel.addColumn("Item Price");
            AvailableItemsTable.setModel(availableItemsModel);

            UABakeryDriver x = new UABakeryDriver();

            ArrayList<UABakery> list = x.getAll();
            for(int i = 0; i < list.size(); i++){
                String[] row = new String[3];
                row[0] = list.get(i).getBAKERY_ITEM_ID()+"";
                row[1] = list.get(i).getBAKERY_ITEM_NAME();
                row[2] = list.get(i).getBAKERY_ITEM_PRICE()+"";
                availableItemsModel.addRow(row);
            }
        }
        
        {
            availableCustomersModel = new DefaultTableModel();
            availableCustomersModel.addColumn("Customer ID");
            availableCustomersModel.addColumn("Customer Name");
            CustomersOrdersTable.setModel(availableCustomersModel);

            UACustomerDriver x = new UACustomerDriver();

            ArrayList<UACustomer> list = x.getAll();
            for(int i = 0; i < list.size(); i++){
                String[] row = new String[2];
                row[0] = list.get(i).getCUST_ID() + "";
                row[1] = list.get(i).getCUST_FIRST_NAME() + " " + list.get(i).getCUST_LAST_NAME();
                availableCustomersModel.addRow(row);
            }
        }
        
        {
            cartModel = new DefaultTableModel();
            cartModel.addColumn("Item ID");
            cartModel.addColumn("Item Name");
            cartModel.addColumn("Item(s) Total Price");
            cartModel.addColumn("Quantity");
            CartTable.setModel(cartModel);
        }
        
        {
            customerSearchModel = new DefaultTableModel();
            customerSearchModel.addColumn("Order ID");
            customerSearchModel.addColumn("Order Details ID");
            customerSearchModel.addColumn("Bakery Item ID");
            customerSearchModel.addColumn("Quantity");
            customerSearchModel.addColumn("Order Time");
            customerSearchModel.addColumn("Order Date");
            CustomerSearchTable.setModel(customerSearchModel);
        }
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        CustomerPanel = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        CustomerFullNameInput = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        CustomerAddressInput = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        CustomerPhoneInput = new javax.swing.JTextField();
        CustomerEmailInput = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        CustomerUsernameInput = new javax.swing.JTextField();
        ItemScrollPane1 = new javax.swing.JScrollPane();
        CustomerTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        CustomerIDInput = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        RefreshCustomersTable = new javax.swing.JButton();
        AddCustomer = new javax.swing.JButton();
        RemoveCustomer = new javax.swing.JButton();
        CustomerPasswordInput = new javax.swing.JPasswordField();
        ItemPanel = new javax.swing.JPanel();
        ItemScrollPane = new javax.swing.JScrollPane();
        ItemTable = new javax.swing.JTable();
        ItemNameInput = new javax.swing.JTextField();
        ItemDescriptionInput = new javax.swing.JTextField();
        ItemPriceInput = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ItemIDInput = new javax.swing.JTextField();
        AddItem = new javax.swing.JButton();
        RemoveItem = new javax.swing.JButton();
        RefreshItemsTable = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        InventoryPanel = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        InventoryReorderAmountInput = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        InventoryDescriptionInput = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        InventoryNameInput = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        InventoryQuantityOnHandInput = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        InventoryReorderPriceInput = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        InventoryIDInput = new javax.swing.JTextField();
        AddInventory = new javax.swing.JButton();
        RemoveInventory = new javax.swing.JButton();
        ItemScrollPane2 = new javax.swing.JScrollPane();
        InventoryTable = new javax.swing.JTable();
        RefreshInventoryTable = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        OrderPanel = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        OrderIDInput = new javax.swing.JTextField();
        RemoveOrder = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrdersTable = new javax.swing.JTable();
        RefreshOrdersTable = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        OrderDetailsTable = new javax.swing.JTable();
        RefreshOrderDetailsTable = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AvailableItemsTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        AddOrder1 = new javax.swing.JButton();
        Checkout = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        CustomersOrdersTable = new javax.swing.JTable();
        QuantitiesInput = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        RefreshAvailableCustomers = new javax.swing.JButton();
        subtotal = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        CustomerSearchPanel = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        NameSearchInput = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        OrderSearchInput = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        CustomerSearchTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        Title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(250, 250, 255));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N

        CustomerPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Remove Customer");

        jLabel9.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Full Name:");

        CustomerFullNameInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        CustomerFullNameInput.setText("FirstName LastName");
        CustomerFullNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerFullNameInputActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Full Address:");

        CustomerAddressInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        CustomerAddressInput.setText("City,State,Zip");
        CustomerAddressInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerAddressInputActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Email:");

        jLabel12.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Phone:");

        CustomerPhoneInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        CustomerPhoneInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerPhoneInputActionPerformed(evt);
            }
        });

        CustomerEmailInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        CustomerEmailInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerEmailInputActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel13.setText("Password:");

        jLabel14.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel14.setText("Username:");

        CustomerUsernameInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        CustomerUsernameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerUsernameInputActionPerformed(evt);
            }
        });

        CustomerTable.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        CustomerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer Name", "Customer Phone", "Customer Email", "Customer Username", "Customer Password", "Customer Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ItemScrollPane1.setViewportView(CustomerTable);

        jLabel15.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel15.setText("Customers");

        jLabel16.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel16.setText("Customer ID:");

        CustomerIDInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        CustomerIDInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CustomerIDInputActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel17.setText("Add New Customer");

        RefreshCustomersTable.setText("Refresh");
        RefreshCustomersTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshCustomersTableActionPerformed(evt);
            }
        });

        AddCustomer.setText("Add Customer");
        AddCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCustomerActionPerformed(evt);
            }
        });

        RemoveCustomer.setText("Remove Customer");
        RemoveCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveCustomerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CustomerPanelLayout = new javax.swing.GroupLayout(CustomerPanel);
        CustomerPanel.setLayout(CustomerPanelLayout);
        CustomerPanelLayout.setHorizontalGroup(
            CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustomerPanelLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(CustomerPanelLayout.createSequentialGroup()
                        .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerPanelLayout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CustomerPanelLayout.createSequentialGroup()
                                        .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel8)
                                            .addGroup(CustomerPanelLayout.createSequentialGroup()
                                                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(10, 10, 10)))
                                        .addGap(12, 12, 12)))
                                .addGap(41, 41, 41)
                                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CustomerIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerPhoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerAddressInput, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(CustomerPanelLayout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(AddCustomer))
                                    .addComponent(CustomerFullNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CustomerPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 535, Short.MAX_VALUE))
                            .addGroup(CustomerPanelLayout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RefreshCustomersTable))
                            .addComponent(ItemScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())))
            .addGroup(CustomerPanelLayout.createSequentialGroup()
                .addGap(202, 202, 202)
                .addComponent(RemoveCustomer)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CustomerPanelLayout.setVerticalGroup(
            CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerFullNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerAddressInput, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CustomerPhoneInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerEmailInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerUsernameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerPasswordInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addComponent(AddCustomer)
                .addGap(13, 13, 13)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CustomerIDInput, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addGroup(CustomerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CustomerPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(RemoveCustomer)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CustomerPanelLayout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(RefreshCustomersTable)
                        .addGap(6, 6, 6)))
                .addComponent(ItemScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Customers", CustomerPanel);

        ItemPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        ItemTable.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        ItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Item Description", "Item Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ItemScrollPane.setViewportView(ItemTable);

        ItemNameInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        ItemNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemNameInputActionPerformed(evt);
            }
        });

        ItemDescriptionInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N

        ItemPriceInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel2.setText("Price:");

        jLabel3.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel3.setText("Description:");

        jLabel4.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel4.setText("Item ID:");

        ItemIDInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N

        AddItem.setText("Add New Item");
        AddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddItemActionPerformed(evt);
            }
        });

        RemoveItem.setText("Remove Item");
        RemoveItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveItemActionPerformed(evt);
            }
        });

        RefreshItemsTable.setText("Refresh");
        RefreshItemsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshItemsTableActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel5.setText("Remove Item");

        jLabel6.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Add New Bakery Item");

        jLabel7.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Bakery Items");

        javax.swing.GroupLayout ItemPanelLayout = new javax.swing.GroupLayout(ItemPanel);
        ItemPanel.setLayout(ItemPanelLayout);
        ItemPanelLayout.setHorizontalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ItemPanelLayout.createSequentialGroup()
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ItemPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ItemPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 1298, Short.MAX_VALUE))
                            .addComponent(ItemScrollPane)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemPanelLayout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RefreshItemsTable))))
                    .addGroup(ItemPanelLayout.createSequentialGroup()
                        .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ItemPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ItemPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(76, 76, 76)
                                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ItemDescriptionInput)
                                    .addGroup(ItemPanelLayout.createSequentialGroup()
                                        .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ItemPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ItemIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(ItemNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(ItemPanelLayout.createSequentialGroup()
                                                .addGap(58, 58, 58)
                                                .addComponent(AddItem)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(51, 51, 51))
                    .addGroup(ItemPanelLayout.createSequentialGroup()
                        .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ItemPanelLayout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ItemPanelLayout.createSequentialGroup()
                                .addGap(239, 239, 239)
                                .addComponent(RemoveItem)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        ItemPanelLayout.setVerticalGroup(
            ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ItemNameInput, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemDescriptionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addComponent(AddItem)
                .addGap(32, 32, 32)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ItemIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(RemoveItem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(ItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemPanelLayout.createSequentialGroup()
                        .addComponent(RefreshItemsTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ItemPanelLayout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)))
                .addComponent(ItemScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Items", ItemPanel);

        InventoryPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel18.setText("Add New Inventory");

        jLabel19.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel19.setText("Name:");

        InventoryReorderAmountInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N

        jLabel20.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel20.setText("Description:");

        InventoryDescriptionInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel21.setText("Reorder Amount:");

        InventoryNameInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel22.setText("Quantity On Hand:");

        InventoryQuantityOnHandInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel23.setText("Reorder Price:");

        InventoryReorderPriceInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N

        jLabel24.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel24.setText("Add New Inventory");

        jLabel25.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel25.setText("Inventory ID:");

        InventoryIDInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        InventoryIDInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InventoryIDInputActionPerformed(evt);
            }
        });

        AddInventory.setText("Add Inventory");
        AddInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddInventoryActionPerformed(evt);
            }
        });

        RemoveInventory.setText("Remove Inventory");
        RemoveInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveInventoryActionPerformed(evt);
            }
        });

        InventoryTable.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        InventoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Inventory ID", "Inventory Name", "Inventory Description", "Quantity", "Reorder Amount", "Reorder Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        ItemScrollPane2.setViewportView(InventoryTable);

        RefreshInventoryTable.setText("Refresh");
        RefreshInventoryTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshInventoryTableActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel26.setText("Inventory");

        javax.swing.GroupLayout InventoryPanelLayout = new javax.swing.GroupLayout(InventoryPanel);
        InventoryPanel.setLayout(InventoryPanelLayout);
        InventoryPanelLayout.setHorizontalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ItemScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventoryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(RefreshInventoryTable)))
                .addContainerGap())
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InventoryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel24)))
                    .addGroup(InventoryPanelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addGroup(InventoryPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel21))
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventoryPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(InventoryIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventoryDescriptionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventoryNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(InventoryReorderAmountInput, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(InventoryQuantityOnHandInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(InventoryReorderPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(584, Short.MAX_VALUE))
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(InventoryPanelLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(RemoveInventory))
                    .addGroup(InventoryPanelLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(AddInventory)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        InventoryPanelLayout.setVerticalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(InventoryNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventoryDescriptionInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventoryQuantityOnHandInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventoryReorderAmountInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventoryReorderPriceInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(AddInventory)
                .addGap(8, 8, 8)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InventoryIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addComponent(RemoveInventory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventoryPanelLayout.createSequentialGroup()
                        .addComponent(RefreshInventoryTable)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventoryPanelLayout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addComponent(ItemScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventory", InventoryPanel);

        OrderPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel27.setText("Remove Order");

        jLabel29.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel29.setText("Order ID:");

        jLabel32.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel32.setText("Create New Order");

        OrderIDInput.setFont(new java.awt.Font("Malgun Gothic", 0, 11)); // NOI18N
        OrderIDInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderIDInputActionPerformed(evt);
            }
        });

        RemoveOrder.setText("Remove Order");
        RemoveOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RemoveOrderActionPerformed(evt);
            }
        });

        OrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Order Date", "Order Time", "Customer ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(OrdersTable);

        RefreshOrdersTable.setText("Refresh");
        RefreshOrdersTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshOrdersTableActionPerformed(evt);
            }
        });

        OrderDetailsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order Details ID", "Associated Order ID", "Bakery Item ID", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(OrderDetailsTable);

        RefreshOrderDetailsTable.setText("Refresh");
        RefreshOrderDetailsTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshOrderDetailsTableActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel33.setText("Orders");

        jLabel34.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel34.setText("Order Details");

        AvailableItemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item ID", "Item Name", "Item Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(AvailableItemsTable);

        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(CartTable);

        jLabel35.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel35.setText("Cart:");

        jLabel36.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel36.setText("Available Items:");

        AddOrder1.setText("Add to Cart");
        AddOrder1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddOrder1ActionPerformed(evt);
            }
        });

        Checkout.setText("Checkout for:");
        Checkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckoutActionPerformed(evt);
            }
        });

        CustomersOrdersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Customer ID", "Customer Name"
            }
        ));
        jScrollPane5.setViewportView(CustomersOrdersTable);

        jLabel28.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel28.setText("Quantity of");

        jLabel30.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel30.setText("selected Item:");

        RefreshAvailableCustomers.setText("Refresh");
        RefreshAvailableCustomers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RefreshAvailableCustomersActionPerformed(evt);
            }
        });

        subtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subtotalActionPerformed(evt);
            }
        });

        jLabel39.setText("Order Total");

        javax.swing.GroupLayout OrderPanelLayout = new javax.swing.GroupLayout(OrderPanel);
        OrderPanel.setLayout(OrderPanelLayout);
        OrderPanelLayout.setHorizontalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderPanelLayout.createSequentialGroup()
                        .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(OrderPanelLayout.createSequentialGroup()
                                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(OrderPanelLayout.createSequentialGroup()
                                            .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(205, 205, 205)
                                            .addComponent(RefreshOrderDetailsTable)))
                                    .addGroup(OrderPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel34)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(RefreshOrdersTable)))
                                .addGap(175, 410, Short.MAX_VALUE))
                            .addGroup(OrderPanelLayout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OrderPanelLayout.createSequentialGroup()
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(OrderPanelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(jLabel28))
                                            .addComponent(QuantitiesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel30)
                                            .addComponent(AddOrder1)))
                                    .addComponent(jLabel36))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(OrderPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel35)
                                        .addGap(879, 879, 879)
                                        .addComponent(RefreshAvailableCustomers))
                                    .addGroup(OrderPanelLayout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Checkout)
                                        .addGap(32, 32, 32)
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)))
                        .addGap(47, 47, 47))
                    .addGroup(OrderPanelLayout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(OrderPanelLayout.createSequentialGroup()
                        .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 991, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(OrderPanelLayout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(OrderIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(129, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RemoveOrder, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))))))
            .addGroup(OrderPanelLayout.createSequentialGroup()
                .addGap(610, 610, 610)
                .addComponent(jLabel39)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        OrderPanelLayout.setVerticalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RefreshAvailableCustomers, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderPanelLayout.createSequentialGroup()
                        .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(OrderPanelLayout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(QuantitiesInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AddOrder1)
                                .addGap(117, 117, 117)
                                .addComponent(jLabel33))
                            .addGroup(OrderPanelLayout.createSequentialGroup()
                                .addGap(121, 121, 121)
                                .addComponent(Checkout)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(RefreshOrderDetailsTable)))
                        .addGap(6, 6, 6))
                    .addGroup(OrderPanelLayout.createSequentialGroup()
                        .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(subtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(RefreshOrdersTable)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(OrderPanelLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrderIDInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(44, 44, 44)
                        .addComponent(RemoveOrder))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Orders", OrderPanel);

        CustomerSearchPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel37.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel37.setText("Order by Customer");

        jLabel31.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel31.setText("Name:");

        jLabel38.setFont(new java.awt.Font("Malgun Gothic", 0, 14)); // NOI18N
        jLabel38.setText("Specific Order ID:");

        CustomerSearchTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(CustomerSearchTable);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Search with ID");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CustomerSearchPanelLayout = new javax.swing.GroupLayout(CustomerSearchPanel);
        CustomerSearchPanel.setLayout(CustomerSearchPanelLayout);
        CustomerSearchPanelLayout.setHorizontalGroup(
            CustomerSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerSearchPanelLayout.createSequentialGroup()
                .addGroup(CustomerSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CustomerSearchPanelLayout.createSequentialGroup()
                        .addGroup(CustomerSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CustomerSearchPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel37))
                            .addGroup(CustomerSearchPanelLayout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addGroup(CustomerSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel38)
                                    .addComponent(jLabel31))
                                .addGap(45, 45, 45)
                                .addGroup(CustomerSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(CustomerSearchPanelLayout.createSequentialGroup()
                                        .addComponent(OrderSearchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(103, 103, 103)
                                        .addComponent(jButton1)
                                        .addGap(123, 123, 123)
                                        .addComponent(jButton2))
                                    .addComponent(NameSearchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 501, Short.MAX_VALUE)))
                .addContainerGap())
        );
        CustomerSearchPanelLayout.setVerticalGroup(
            CustomerSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CustomerSearchPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(CustomerSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NameSearchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CustomerSearchPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(OrderSearchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Customer Search", CustomerSearchPanel);

        Title.setFont(new java.awt.Font("Malgun Gothic", 0, 36)); // NOI18N
        Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Title.setText("Noah's Bakery GUI");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(521, 521, 521)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CustomerAddressInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerAddressInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerAddressInputActionPerformed

    private void CustomerPhoneInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerPhoneInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerPhoneInputActionPerformed

    private void CustomerEmailInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerEmailInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerEmailInputActionPerformed

    private void CustomerUsernameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerUsernameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerUsernameInputActionPerformed

    private void CustomerIDInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerIDInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerIDInputActionPerformed

    private void AddCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCustomerActionPerformed
        if(CustomerPhoneInput.getText().equals("") || CustomerEmailInput.getText().equals("") || CustomerUsernameInput.getText().equals("") || CustomerPasswordInput.getText().equals("")){
            JOptionPane.showMessageDialog(CustomerPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE);
        } else {
            UACustomerDriver x = new UACustomerDriver();
            UACustomer cust = new UACustomer();
            cust.setCUST_FIRST_NAME(CustomerFullNameInput.getText().split(" ")[0]);
            cust.setCUST_LAST_NAME(CustomerFullNameInput.getText().split(" ")[1]);
            cust.setCUST_ADDRESS(CustomerAddressInput.getText());
            cust.setCUST_CITY(CustomerAddressInput.getText().split(",")[0]);
            cust.setCUST_CITY(CustomerAddressInput.getText().split(",")[1]);
            cust.setCUST_ZIP(CustomerAddressInput.getText().split(",")[2]);
            cust.setCUST_PHONE(CustomerPhoneInput.getText());
            cust.setCUST_EMAIL(CustomerEmailInput.getText());
            cust.setCUST_USERNAME(CustomerUsernameInput.getText());
            cust.setCUST_PASSWORD(CustomerPasswordInput.getText());
            x.insert(cust);
        }
    }//GEN-LAST:event_AddCustomerActionPerformed

    private void RemoveCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveCustomerActionPerformed
       
        if(CustomerIDInput.getText().equals("")){
            JOptionPane.showMessageDialog(CustomerPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE);
        } else {
            UACustomerDriver x = new UACustomerDriver();
            UACustomer cust = new UACustomer();
            cust.setCUST_ID(Integer.parseInt(CustomerIDInput.getText()));
            x.remove(cust);
        }
           
        
            
    }//GEN-LAST:event_RemoveCustomerActionPerformed

    private void InventoryIDInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InventoryIDInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InventoryIDInputActionPerformed

    private void AddInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddInventoryActionPerformed
        
        if(InventoryNameInput.getText().equals("")|| InventoryDescriptionInput.getText().equals("")|| InventoryQuantityOnHandInput.getText().equals("")||InventoryReorderPriceInput.getText().equals("")){
            JOptionPane.showMessageDialog(InventoryPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE);
        }else {
            UAInventoryDriver x = new UAInventoryDriver();
            UAInventory inv = new UAInventory();
            inv.setINV_NAME(InventoryNameInput.getText());
            inv.setINV_DESCRIPTION(InventoryDescriptionInput.getText());
            inv.setINV_QTY_ONHAND(Integer.parseInt(InventoryQuantityOnHandInput.getText()));
            inv.setINV_REORDER_AMT(Integer.parseInt(InventoryReorderAmountInput.getText()));
            inv.setINV_REORDER_PRICE(Float.parseFloat(InventoryReorderPriceInput.getText()));
            x.insert(inv);
        }
    }//GEN-LAST:event_AddInventoryActionPerformed

    private void RemoveInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveInventoryActionPerformed
        
        if(InventoryIDInput.getText().equals("")){
           JOptionPane.showMessageDialog(InventoryPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE); 
        } else {
            UAInventoryDriver x = new UAInventoryDriver();
            UAInventory inv = new UAInventory();
            inv.setINV_ID(Integer.parseInt(InventoryIDInput.getText()));
            x.remove(inv);
        }
        
    }//GEN-LAST:event_RemoveInventoryActionPerformed

    private void CustomerFullNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CustomerFullNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CustomerFullNameInputActionPerformed

    private void RefreshCustomersTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshCustomersTableActionPerformed
        
        customerModel = new DefaultTableModel();
        customerModel.addColumn("Customer ID");
        customerModel.addColumn("Customer Name");
        customerModel.addColumn("Customer Phone");
        customerModel.addColumn("Customer Email");
        customerModel.addColumn("Customer Username");
        customerModel.addColumn("Customer Password");
        customerModel.addColumn("Customer Address");
        CustomerTable.setModel(customerModel);
        
        UACustomerDriver x = new UACustomerDriver();
        
        ArrayList<UACustomer> list = x.getAll();
        for(int i = 0; i < list.size(); i++){
            String[] row = new String[7];
            row[0] = list.get(i).getCUST_ID() + "";
            row[1] = list.get(i).getCUST_FIRST_NAME() + " " + list.get(i).getCUST_LAST_NAME();
            row[2] = list.get(i).getCUST_PHONE();
            row[3] = list.get(i).getCUST_EMAIL();
            row[4] = list.get(i).getCUST_USERNAME();
            row[5] = "*hidden*";
            row[6] = list.get(i).getCUST_CITY() + ", " + list.get(i).getCUST_STATE() + ", " + list.get(i).getCUST_ZIP();
            customerModel.addRow(row);
        }
    }//GEN-LAST:event_RefreshCustomersTableActionPerformed

    private void RefreshInventoryTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshInventoryTableActionPerformed
        
        
        inventoryModel = new DefaultTableModel();
        inventoryModel.addColumn("Inventory ID");
        inventoryModel.addColumn("Inventory Name");
        inventoryModel.addColumn("Inventory Description");
        inventoryModel.addColumn("Quantity");
        inventoryModel.addColumn("Reorder Amount");
        inventoryModel.addColumn("Reorder Price");
        InventoryTable.setModel(inventoryModel);
        
        UAInventoryDriver x = new UAInventoryDriver();
                
        ArrayList<UAInventory> list = x.getAll();
        for(int i = 0; i < list.size(); i++){
            String[] row = new String[6];
            row[0] = list.get(i).getINV_ID()+"";
            row[1] = list.get(i).getINV_NAME();
            row[2] = list.get(i).getINV_DESCRIPTION();
            row[3] = list.get(i).getINV_QTY_ONHAND()+"";
            row[4] = list.get(i).getINV_REORDER_AMT()+"";
            row[5] = list.get(i).getINV_REORDER_PRICE()+"";
            inventoryModel.addRow(row);
        }
    }//GEN-LAST:event_RefreshInventoryTableActionPerformed

    private void RefreshItemsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshItemsTableActionPerformed
        
        
        bakeryModel = new DefaultTableModel();
        bakeryModel.addColumn("Item ID");
        bakeryModel.addColumn("Item Name");
        bakeryModel.addColumn("Item Description");
        bakeryModel.addColumn("Item Price");
        ItemTable.setModel(bakeryModel);
        
        UABakeryDriver x = new UABakeryDriver();
                
        ArrayList<UABakery> list = x.getAll();
        for(int i = 0; i < list.size(); i++){
            String[] row = new String[4];
            row[0] = list.get(i).getBAKERY_ITEM_ID()+"";
            row[1] = list.get(i).getBAKERY_ITEM_NAME();
            row[2] = list.get(i).getBAKERY_ITEM_DESCRIPTION();
            row[3] = list.get(i).getBAKERY_ITEM_PRICE()+"";
            bakeryModel.addRow(row);
        }
    }//GEN-LAST:event_RefreshItemsTableActionPerformed

    private void RemoveItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveItemActionPerformed
        
        if(ItemIDInput.getText().equals("")){
            JOptionPane.showMessageDialog(ItemPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE);
        } else {
            UABakeryDriver x = new UABakeryDriver();
            UABakery bak = new UABakery();
            bak.setBAKERY_ITEM_ID(Integer.parseInt(ItemIDInput.getText()));
            x.remove(bak);
        }
    }//GEN-LAST:event_RemoveItemActionPerformed

    private void AddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddItemActionPerformed
        
        if(ItemNameInput.getText().equals("") || ItemDescriptionInput.getText().equals("") || ItemPriceInput.getText().equals("")){
            JOptionPane.showMessageDialog(ItemPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE);
        } else {
            UABakeryDriver x = new UABakeryDriver();
            UABakery bak = new UABakery();
            bak.setBAKERY_ITEM_NAME(ItemNameInput.getText());
            bak.setBAKERY_ITEM_DESCRIPTION(ItemDescriptionInput.getText());
            bak.setBAKERY_ITEM_PRICE(Float.parseFloat(ItemPriceInput.getText()));
            x.insert(bak);
        }
    }//GEN-LAST:event_AddItemActionPerformed

    private void ItemNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ItemNameInputActionPerformed

    private void OrderIDInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderIDInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_OrderIDInputActionPerformed

    private void RemoveOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RemoveOrderActionPerformed
        
        if(OrderIDInput.getText().equals("")){
            JOptionPane.showMessageDialog(ItemPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE);
        } else {
            UAOrderDriver x = new UAOrderDriver();
            UAOrder order = new UAOrder();
            order.setORDER_ID(Integer.parseInt(OrderIDInput.getText()));
            x.remove(order);
        }
    }//GEN-LAST:event_RemoveOrderActionPerformed

    private void RefreshOrdersTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshOrdersTableActionPerformed
        
        orderDetailsModel = new DefaultTableModel();
        orderDetailsModel.addColumn("Order Details ID");
        orderDetailsModel.addColumn("Associated Order ID");
        orderDetailsModel.addColumn("Bakery Item ID");
        orderDetailsModel.addColumn("Quantity");
        OrderDetailsTable.setModel(orderDetailsModel);
        
        UAOrderDetailsDriver x = new UAOrderDetailsDriver();
        ArrayList<UAOrderDetails> list = x.getAll();
        
        for(int i = 0; i < list.size(); i++){
            String[] row = new String[4];
            row[0] = list.get(i).getORDER_DETAILS_ID()+"";
            row[1] = list.get(i).getORDER_ID()+"";
            row[2] = list.get(i).getBAKERY_ITEM_ID()+"";
            row[3] = list.get(i).getQUANTITY()+"";
            orderDetailsModel.addRow(row);
        }
    }//GEN-LAST:event_RefreshOrdersTableActionPerformed

    private void RefreshOrderDetailsTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshOrderDetailsTableActionPerformed
           
        ordersModel = new DefaultTableModel();
        ordersModel.addColumn("Order ID");
        ordersModel.addColumn("Order Date");
        ordersModel.addColumn("Order Time");
        ordersModel.addColumn("Customer ID");
        OrdersTable.setModel(ordersModel);
        
        UAOrderDriver x = new UAOrderDriver();
        ArrayList<UAOrder> list = x.getAll();
        
        for(int i = 0; i < list.size(); i++){
            String[] row = new String[4];
            row[0] = list.get(i).getORDER_ID()+"";
            row[1] = list.get(i).getORDER_DATE();
            row[2] = list.get(i).getORDER_TIME();
            row[3] = list.get(i).getCUSTOMERS_CUST_ID()+"";
            ordersModel.addRow(row);
        }
    }//GEN-LAST:event_RefreshOrderDetailsTableActionPerformed

    private void AddOrder1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddOrder1ActionPerformed
        
        if(QuantitiesInput.getText().equals("")){
            JOptionPane.showMessageDialog(OrderPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE);
        } else {
            TableModel model1 = AvailableItemsTable.getModel();
            int indices[] = AvailableItemsTable.getSelectedRows();

            String[] row = new String[4];

            DefaultTableModel model2 = (DefaultTableModel) CartTable.getModel();

            for(int i = 0; i < indices.length; i++){
                row[0] = model1.getValueAt(indices[i], 0).toString();
                row[1] = model1.getValueAt(indices[i], 1).toString();
                row[2] = Float.parseFloat(model1.getValueAt(indices[i], 2).toString())*Float.parseFloat(QuantitiesInput.getText())+"";
                row[3] = Integer.parseInt(QuantitiesInput.getText())+"";

                model2.addRow(row);
            }
            float sub = 0;
            TableModel model3 = CartTable.getModel();
            for(int i = 0; i < model2.getRowCount(); i++){
                sub += Float.parseFloat(model2.getValueAt(i, 2).toString());
            }
            subtotal.setText(sub+"");
        }
        
    }//GEN-LAST:event_AddOrder1ActionPerformed

    private void CheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckoutActionPerformed
        
        int[] BakeryItemIDs = new int[CartTable.getRowCount()];
        int[] Quantities = new int[CartTable.getRowCount()];
        for(int i = 0; i < CartTable.getRowCount(); i++){
            BakeryItemIDs[i] = Integer.parseInt(CartTable.getValueAt(i, 0).toString());
            Quantities[i] = Integer.parseInt(CartTable.getValueAt(i,3).toString());                     
        }
        
        //fill ingredients with all items needed total for complete order
        boolean enoughInventory = true;
        HashMap<Integer, Integer> ingredients = new HashMap<>();
        for(int i = 0; i < BakeryItemIDs.length; i++){
            UARecipeDriver rec = new UARecipeDriver();
            ArrayList<int[]> hold = rec.getIngredients(BakeryItemIDs[i]);
            for(int j = 0; j < hold.size(); j++){
                if(ingredients.get(hold.get(j)[0]) == null){
                    ingredients.put(    hold.get(j)[0]   ,    hold.get(j)[1]    *    Quantities[i]   );
                } else{
                    int previouscount = ingredients.remove(hold.get(j)[0]);
                    ingredients.put(    hold.get(j)[0]   ,   previouscount    +    hold.get(j)[1] * Quantities[i]    );
                }
            }
        }
        
        
        //check using ingredients to see if there is enough in stock to provide the order
        ArrayList<Integer> restocks = new ArrayList<>();
        UAInventoryDriver inv = new UAInventoryDriver();
        for(int key : ingredients.keySet()){
            if(!inv.checkAvailableInventory(key,ingredients.get(key))){
                enoughInventory = false;
                restocks.add(key);
            }
        }
        
        if(enoughInventory){
            //if enough inventory is in stock provide order and update inventory after
            
            int customersIndex = CustomersOrdersTable.getSelectedRow();
            if(customersIndex==-1){
                JOptionPane.showMessageDialog(OrderPanel, "Please select a customer for this checkout.", "Checkout warning", JOptionPane.WARNING_MESSAGE);
            } else {
            
                UAOrderDriver o = new UAOrderDriver();
                UAOrder order = new UAOrder();
                order.setORDER_DATE(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
                order.setORDER_TIME(new SimpleDateFormat("HH.mm.ss").format(Calendar.getInstance().getTime()));
                order.setCUSTOMERS_CUST_ID(Integer.parseInt(availableCustomersModel.getValueAt(customersIndex, 0).toString()));
                //order
                o.insert(order);

                UAOrderDetailsDriver od = new UAOrderDetailsDriver();

                int currentOrderID = od.getID();
                for(int i = 0; i < BakeryItemIDs.length; i++){

                    UAOrderDetails orderDetails = new UAOrderDetails();
                    orderDetails.setORDER_ID(currentOrderID);
                    orderDetails.setBAKERY_ITEM_ID(BakeryItemIDs[i]);
                    orderDetails.setQUANTITY(Quantities[i]);

                    //order details of order
                    od.insert(orderDetails);
                }
                //inventory updates
                for(int key : ingredients.keySet()){
                    inv.updateInventory(key, ingredients.get(key));
                }

                cartModel = new DefaultTableModel();
                cartModel.addColumn("Item ID");
                cartModel.addColumn("Item Name");
                cartModel.addColumn("Item(s) Total Price");
                cartModel.addColumn("Quantity");
                CartTable.setModel(cartModel);
            }
            //TRANSACTION JOURNAL STUFF
            TransactionJournalDriver tjd = new TransactionJournalDriver();
            TransactionJournal t = new TransactionJournal();
            UABakeryDriver bak = new UABakeryDriver();
            
            t.setJOURNAL_AMOUNT(tjd.getJournalAmount() + Float.parseFloat(subtotal.getText()));//change it so its not the same value, need to add what the order gave us (+ however much the order was to our net cash)
            StringBuilder description = new StringBuilder();
            description.append("SUCCESFUL ORDER OF ");
            description.append(bak.getName(BakeryItemIDs[0]));//this is fine for now since he said to assume there would now only be orders of one type of item at a time
            description.append(" X ");
            description.append(Quantities[0]);
            t.setJOURNAL_DESCRIPTION(description.toString());
            t.setJOURNAL_TIME(new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(Calendar.getInstance().getTime()));
            tjd.insert(t);
        } else {
            
            //if not enough inventory ask if they would like to request a reorder or just cancel their order
            Object[] options = {"Request Reorder",
                    "No, thanks"};
            int response = JOptionPane.showOptionDialog(OrderPanel,
                "One or more items you added to cart do not \ncurrently have sufficient stock to provide \nyour order, would you like to request an \ninventory restock from the provider?",
                "Inventory Error",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);
            
            if(response == 0){
                TransactionJournalDriver tjd = new TransactionJournalDriver();
                float restockPrice = inv.restockPrice(restocks);
                if(tjd.getJournalAmount() >= restockPrice){
                    for(int i = 0; i < restocks.size(); i++){
                        inv.restock(restocks.get(i));
                    }
                    try{
                        JOptionPane.showMessageDialog(OrderPanel, "Please wait while we restock that for you");
                        Thread.sleep(4000);
                        JOptionPane.showMessageDialog(OrderPanel, "Our inventory has been updated, please try your order again");
                    } catch(Exception ex){

                    }
                    
                    TransactionJournal t = new TransactionJournal();
                    
                    t.setJOURNAL_AMOUNT(tjd.getJournalAmount() - restockPrice);
                    StringBuilder description = new StringBuilder();
                    description.append("ORDERING INVENTORY ITEM ");
                    description.append(inv.getName(restocks.get(0)));//this is fine for now since he said to assume there would now only be orders of one type of item at a time
                    description.append(" WITH A QUANTITY OF ");
                    description.append(inv.getReorderAmount(restocks.get(0)));
                    t.setJOURNAL_DESCRIPTION(description.toString());
                    t.setJOURNAL_TIME(new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(Calendar.getInstance().getTime()));
                    tjd.insert(t);
                } else {
                    JOptionPane.showMessageDialog(OrderPanel, "Unfortunately we do not have sufficient funds currently to restock the needed ingredients for your order");
                }
            }
        }
        
    }//GEN-LAST:event_CheckoutActionPerformed

    private void RefreshAvailableCustomersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RefreshAvailableCustomersActionPerformed
        
        availableCustomersModel = new DefaultTableModel();
        availableCustomersModel.addColumn("Customer ID");
        availableCustomersModel.addColumn("Customer Name");
        CustomersOrdersTable.setModel(availableCustomersModel);
        
        UACustomerDriver x = new UACustomerDriver();
        
        ArrayList<UACustomer> list = x.getAll();
        for(int i = 0; i < list.size(); i++){
            String[] row = new String[2];
            row[0] = list.get(i).getCUST_ID() + "";
            row[1] = list.get(i).getCUST_FIRST_NAME() + " " + list.get(i).getCUST_LAST_NAME();
            availableCustomersModel.addRow(row);
        }
    }//GEN-LAST:event_RefreshAvailableCustomersActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        if(!NameSearchInput.getText().equals("")){
            customerSearchModel = new DefaultTableModel();
                customerSearchModel.addColumn("Order ID");
                customerSearchModel.addColumn("Order Details ID");
                customerSearchModel.addColumn("Bakery Item ID");
                customerSearchModel.addColumn("Quantity");
                customerSearchModel.addColumn("Order Time");
                customerSearchModel.addColumn("Order Date");
                CustomerSearchTable.setModel(customerSearchModel);

            UAOrderDetailsDriver od = new UAOrderDetailsDriver();

            ArrayList<CompleteOrder> list = od.getAllOrdersByCust(NameSearchInput.getText());

            for(int i = 0; i < list.size(); i++){
                String[] row = new String[6];
                row[0] = list.get(i).getORDER_ID()+"";
                row[1] = list.get(i).getORDER_DETAILS_ID()+"";
                row[2] = list.get(i).getBAKERY_ITEM_ID()+"";
                row[3] = list.get(i).getQUANTITY()+"";
                row[4] = list.get(i).getORDER_TIME();
                row[5] = list.get(i).getORDER_DATE();
                customerSearchModel.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(CustomerSearchPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if(!NameSearchInput.getText().equals("") && !OrderSearchInput.getText().equals("")){
        customerSearchModel = new DefaultTableModel();
            customerSearchModel.addColumn("Order ID");
            customerSearchModel.addColumn("Order Details ID");
            customerSearchModel.addColumn("Bakery Item ID");
            customerSearchModel.addColumn("Quantity");
            customerSearchModel.addColumn("Order Time");
            customerSearchModel.addColumn("Order Date");
            CustomerSearchTable.setModel(customerSearchModel);
        
        UAOrderDetailsDriver od = new UAOrderDetailsDriver();
        
        ArrayList<CompleteOrder> list = od.getSpecificOrderByCust(NameSearchInput.getText(),Integer.parseInt(OrderSearchInput.getText()));
        
        for(int i = 0; i < list.size(); i++){
            String[] row = new String[6];
            row[0] = list.get(i).getORDER_ID()+"";
            row[1] = list.get(i).getORDER_DETAILS_ID()+"";
            row[2] = list.get(i).getBAKERY_ITEM_ID()+"";
            row[3] = list.get(i).getQUANTITY()+"";
            row[4] = list.get(i).getORDER_TIME();
            row[5] = list.get(i).getORDER_DATE();
            customerSearchModel.addRow(row);
        }
        } else {
            JOptionPane.showMessageDialog(CustomerSearchPanel, "Please properly fill out all fields.", "Field warning", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void subtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subtotalActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddCustomer;
    private javax.swing.JButton AddInventory;
    private javax.swing.JButton AddItem;
    private javax.swing.JButton AddOrder1;
    private javax.swing.JTable AvailableItemsTable;
    private javax.swing.JTable CartTable;
    private javax.swing.JButton Checkout;
    private javax.swing.JTextField CustomerAddressInput;
    private javax.swing.JTextField CustomerEmailInput;
    private javax.swing.JTextField CustomerFullNameInput;
    private javax.swing.JTextField CustomerIDInput;
    private javax.swing.JPanel CustomerPanel;
    private javax.swing.JPasswordField CustomerPasswordInput;
    private javax.swing.JTextField CustomerPhoneInput;
    private javax.swing.JPanel CustomerSearchPanel;
    private javax.swing.JTable CustomerSearchTable;
    private javax.swing.JTable CustomerTable;
    private javax.swing.JTextField CustomerUsernameInput;
    private javax.swing.JTable CustomersOrdersTable;
    private javax.swing.JTextField InventoryDescriptionInput;
    private javax.swing.JTextField InventoryIDInput;
    private javax.swing.JTextField InventoryNameInput;
    private javax.swing.JPanel InventoryPanel;
    private javax.swing.JTextField InventoryQuantityOnHandInput;
    private javax.swing.JTextField InventoryReorderAmountInput;
    private javax.swing.JTextField InventoryReorderPriceInput;
    private javax.swing.JTable InventoryTable;
    private javax.swing.JTextField ItemDescriptionInput;
    private javax.swing.JTextField ItemIDInput;
    private javax.swing.JTextField ItemNameInput;
    private javax.swing.JPanel ItemPanel;
    private javax.swing.JTextField ItemPriceInput;
    private javax.swing.JScrollPane ItemScrollPane;
    private javax.swing.JScrollPane ItemScrollPane1;
    private javax.swing.JScrollPane ItemScrollPane2;
    private javax.swing.JTable ItemTable;
    private javax.swing.JTextField NameSearchInput;
    private javax.swing.JTable OrderDetailsTable;
    private javax.swing.JTextField OrderIDInput;
    private javax.swing.JPanel OrderPanel;
    private javax.swing.JTextField OrderSearchInput;
    private javax.swing.JTable OrdersTable;
    private javax.swing.JTextField QuantitiesInput;
    private javax.swing.JButton RefreshAvailableCustomers;
    private javax.swing.JButton RefreshCustomersTable;
    private javax.swing.JButton RefreshInventoryTable;
    private javax.swing.JButton RefreshItemsTable;
    private javax.swing.JButton RefreshOrderDetailsTable;
    private javax.swing.JButton RefreshOrdersTable;
    private javax.swing.JButton RemoveCustomer;
    private javax.swing.JButton RemoveInventory;
    private javax.swing.JButton RemoveItem;
    private javax.swing.JButton RemoveOrder;
    private javax.swing.JLabel Title;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField subtotal;
    // End of variables declaration//GEN-END:variables
}
