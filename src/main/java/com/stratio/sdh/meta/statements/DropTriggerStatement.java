package com.stratio.sdh.meta.statements;

import com.stratio.sdh.meta.structures.Path;

public class DropTriggerStatement extends Statement{

    private String ident;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    private String ident2;

    public String getIdent2() {
        return ident2;
    }

    public void setIdent2(String ident2) {
        this.ident2 = ident2;
    }

    public DropTriggerStatement(String ident, String ident2) {
        this.ident = ident;
        this.ident2 = ident2;
    }
       
    @Override
    public Path estimatePath() {
    return Path.CASSANDRA;    
    }

    @Override
    public String toString() {
    StringBuilder sb = new StringBuilder("Drop trigger ");
        sb.append(ident);
        sb.append(" on ");
        sb.append(ident2);
        return sb.toString();
    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public String getSuggestion() {
        return this.getClass().toString().toUpperCase()+" EXAMPLE";
    }
        
}
