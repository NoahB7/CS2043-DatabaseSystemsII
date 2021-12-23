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
public class UARecipe {
    
    private int RECIPE_ID;
	private int BAKERY_ITEM_ID;
	private int INV_ID;
	private int INV_QTY_NEEDED;
	
	public int getRECIPE_ID() {
		return RECIPE_ID;
	}
	public void setRECIPE_ID(int rECIPE_ID) {
		RECIPE_ID = rECIPE_ID;
	}
	public int getBAKERY_ITEM_ID() {
		return BAKERY_ITEM_ID;
	}
	public void setBAKERY_ITEM_ID(int bAKERY_ITEM_ID) {
		BAKERY_ITEM_ID = bAKERY_ITEM_ID;
	}
	public int getINV_ID() {
		return INV_ID;
	}
	public void setINV_ID(int iNV_ID) {
		INV_ID = iNV_ID;
	}
	public int getINV_QTY_NEEDED() {
		return INV_QTY_NEEDED;
	}
	public void setINV_QTY_NEEDED(int iNV_QTY_NEEDED) {
		INV_QTY_NEEDED = iNV_QTY_NEEDED;
	}
}
