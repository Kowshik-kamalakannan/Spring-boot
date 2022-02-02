package com.onlinestore.project.Model;

public class Order {
    private int order_id;
    private String order_desc;
    private Customer customer;

    
    public Order(int order_id, String order_desc, Customer customer) {
        this.order_id = order_id;
        this.order_desc = order_desc;
        this.customer = customer;
    }
    public int getOrder_id() {
        return order_id;
    }
    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }
    public String getOrder_desc() {
        return order_desc;
    }
    public void setOrder_desc(String order_desc) {
        this.order_desc = order_desc;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    
}
