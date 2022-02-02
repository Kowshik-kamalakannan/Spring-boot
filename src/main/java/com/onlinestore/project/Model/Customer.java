package com.onlinestore.project.Model;

public class Customer {
    private int cus_id;
    private String cus_name;
    private String cus_Loc;
    private String cus_email;
    
    public Customer(int cus_id, String cus_name, String cus_Loc, String cus_email) {
        this.cus_id = cus_id;
        this.cus_name = cus_name;
        this.cus_Loc = cus_Loc;
        this.cus_email = cus_email;
    }
    public int getCus_id() {
        return cus_id;
    }
    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }
    public String getCus_name() {
        return cus_name;
    }
    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }
    public String getCus_Loc() {
        return cus_Loc;
    }
    public void setCus_Loc(String cus_Loc) {
        this.cus_Loc = cus_Loc;
    }
    public String getCus_email() {
        return cus_email;
    }
    public void setCus_email(String cus_email) {
        this.cus_email = cus_email;
    }

    

    
}
