package com.onlinestore.project.Model;

public class Product {
    private int product_id;
    private String product_name;
    private String product_desc;
    private int product_quantity;
    private Customer customer;
    public Product(int product_id, String product_name, String product_desc, int product_quantity,Customer customer) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_desc = product_desc;
        this.product_quantity = product_quantity;
        this.customer=customer;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getProduct_id() {
        return product_id;
    }
    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    public String getProduct_desc() {
        return product_desc;
    }
    public void setProduct_desc(String product_desc) {
        this.product_desc = product_desc;
    }
    public int getProduct_quantity() {
        return product_quantity;
    }
    public void setProduct_quantity(int product_quantity) {
        this.product_quantity = product_quantity;
    }
    
    
}
