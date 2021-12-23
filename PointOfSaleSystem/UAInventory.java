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
public class UAInventory {
    
    
	private int INV_ID;
	private String INV_NAME;
	private String INV_DESCRIPTION;
	private int INV_QTY_ONHAND;
	private int INV_REORDER_AMT;
	private float INV_REORDER_PRICE;
	
	
	public int getINV_ID() {
		return INV_ID;
	}
	public void setINV_ID(int iNV_ID) {
		INV_ID = iNV_ID;
	}
	public String getINV_NAME() {
		return INV_NAME;
	}
	public void setINV_NAME(String iNV_NAME) {
		INV_NAME = iNV_NAME;
	}
	public String getINV_DESCRIPTION() {
		return INV_DESCRIPTION;
	}
	public void setINV_DESCRIPTION(String iNV_DESCRIPTION) {
		INV_DESCRIPTION = iNV_DESCRIPTION;
	}
	public int getINV_QTY_ONHAND() {
		return INV_QTY_ONHAND;
	}
	public void setINV_QTY_ONHAND(int iNV_QTY_ONHAND) {
		INV_QTY_ONHAND = iNV_QTY_ONHAND;
	}
	public int getINV_REORDER_AMT() {
		return INV_REORDER_AMT;
	}
	public void setINV_REORDER_AMT(int iNV_REORDER_AMT) {
		INV_REORDER_AMT = iNV_REORDER_AMT;
	}
	public float getINV_REORDER_PRICE() {
		return INV_REORDER_PRICE;
	}
	public void setINV_REORDER_PRICE(float iNV_REORDER_PRICE) {
		INV_REORDER_PRICE = iNV_REORDER_PRICE;
	}

}
