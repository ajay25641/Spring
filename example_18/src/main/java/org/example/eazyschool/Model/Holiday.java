package org.example.eazyschool.Model;

public class Holiday {
    private String day;
    private String reason;
    private Type type;

    public Holiday(String day,String reason,Type type){
        this.day=day;
        this.reason=reason;
        this.type=type;
    }

    public enum Type{
        FESTIVAL,FEDERAL;
    }
    public String getDay(){
        return day;
    }
    public String getReason(){
        return reason;
    }
    public Type getType(){
        return type;
    }
}
