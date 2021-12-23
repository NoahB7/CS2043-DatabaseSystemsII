/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uabakerysystem_nbuchanan;

/**
 *
 * @author noah_
 */
public class CompleteOrder {
    
    private int ORDER_ID;
    private String ORDER_DATE;
    private String ORDER_TIME;
    private int CUSTOMERS_CUST_ID;
    private int ORDER_DETAILS_ID;
    private int BAKERY_ITEM_ID;
    private int QUANTITY;
	
	
    public int getORDER_ID() {
        return ORDER_ID;
    }
	public void setORDER_ID(int oRDER_ID) {
		ORDER_ID = oRDER_ID;
	}
	public String getORDER_DATE() {
		return ORDER_DATE;
	}
	public void setORDER_DATE(String oRDER_DATE) {
		ORDER_DATE = oRDER_DATE;
	}
	public String getORDER_TIME() {
		return ORDER_TIME;
	}
	public void setORDER_TIME(String oRDER_TIME) {
		ORDER_TIME = oRDER_TIME;
	}
	public int getCUSTOMERS_CUST_ID() {
		return CUSTOMERS_CUST_ID;
	}
	public void setCUSTOMERS_CUST_ID(int cUSTOMERS_CUST_ID) {
		CUSTOMERS_CUST_ID = cUSTOMERS_CUST_ID;
	}
	public int getORDER_DETAILS_ID() {
		return ORDER_DETAILS_ID;
	}
	public void setORDER_DETAILS_ID(int oRDER_DETAILS_ID) {
		ORDER_DETAILS_ID = oRDER_DETAILS_ID;
	}
	public int getBAKERY_ITEM_ID() {
		return BAKERY_ITEM_ID;
	}
	public void setBAKERY_ITEM_ID(int bAKERY_ITEM_ID) {
		BAKERY_ITEM_ID = bAKERY_ITEM_ID;
	}
	public int getQUANTITY() {
		return QUANTITY;
	}
	public void setQUANTITY(int qUANTITY) {
		QUANTITY = qUANTITY;
	}
}
