package com.onlinestore.project.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.onlinestore.project.Model.Customer;
import com.onlinestore.project.Model.Product;


@RestController
@RequestMapping("/product")
public class productController {

    List<Product> productList=new ArrayList<>();
    
    {
        productList.add(new Product(1, "Samsung Tv", "Good LED Tv", 1,new Customer(5, "sri", "hyd", "sri@gmail.com")));
        productList.add(new Product(1, "Sony Tv", "Good LcD Tv", 1,new Customer(5, "sri", "hyd", "sri@gmail.com")));
        productList.add(new Product(1, "Huwai Tv", "Good LED Tv", 1,new Customer(5, "sri", "hyd", "sri@gmail.com")));
        productList.add(new Product(1, "Mi Tv", "Good Tv", 1,new Customer(5, "sri", "hyd", "sri@gmail.com")));
        productList.add(new Product(1, "Redmi Tv", "Good Plasma Tv", 1,new Customer(5, "sri", "hyd", "sri@gmail.com")));

    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody Product product)
    {
        productList.add(product);
        return "Product added Sucessfully - id:"+product.getProduct_id();
    }

    @GetMapping("/viewProduct")
    public List<Product> viewProduct()
    {
        return productList;
    }


    @PostMapping("/updateProduct/{id}")
    public Product updateProduct(@PathVariable int id,@RequestBody Product product)
    {
        for(int i=0;i<productList.size();i++)
        {
            if(productList.get(i).getProduct_id()==id)
            {
                productList.add(i,product);
                return productList.get(i);
            }
        }
        return product;
    }

    @DeleteMapping("/deleteProduct")
    public Product deleteProduct(@RequestBody int id)
    {
        Product pro=productList.stream().filter(i->i.getProduct_id()==id).findFirst().get();
        productList.remove(pro);
        return pro;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/getByProductName")
    public List<Product> getProductByName(@RequestParam("name") String name)
    {
        return productList.stream().filter(i->i.getProduct_name().equals(name)).collect(Collectors.toList());
    }

    @PatchMapping("/updateProductName")
    public List<Product> productByName(@RequestParam int id,@RequestParam String name) {
        productList.stream().filter(i->i.getProduct_id()==id).forEach(i->i.setProduct_name(name));
        return productList.stream().filter(i->i.getProduct_id()==id).collect(Collectors.toList());
    }

    
}
