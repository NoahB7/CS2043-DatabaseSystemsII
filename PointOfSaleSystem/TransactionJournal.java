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
public class TransactionJournal {
    
    private int JOURNAL_ID;
    private String JOURNAL_DESCRIPTION;
    private float JOURNAL_AMOUNT;

    public void setJOURNAL_ID(int JOURNAL_ID) {
        this.JOURNAL_ID = JOURNAL_ID;
    }

    public void setJOURNAL_DESCRIPTION(String JOURNAL_DESCRIPTION) {
        this.JOURNAL_DESCRIPTION = JOURNAL_DESCRIPTION;
    }

    public void setJOURNAL_AMOUNT(float JOURNAL_AMOUNT) {
        this.JOURNAL_AMOUNT = JOURNAL_AMOUNT;
    }

    public void setJOURNAL_TIME(String JOURNAL_TIME) {
        this.JOURNAL_TIME = JOURNAL_TIME;
    }

    public int getJOURNAL_ID() {
        return JOURNAL_ID;
    }

    public String getJOURNAL_DESCRIPTION() {
        return JOURNAL_DESCRIPTION;
    }

    public float getJOURNAL_AMOUNT() {
        return JOURNAL_AMOUNT;
    }

    public String getJOURNAL_TIME() {
        return JOURNAL_TIME;
    }
    private String JOURNAL_TIME;
}
