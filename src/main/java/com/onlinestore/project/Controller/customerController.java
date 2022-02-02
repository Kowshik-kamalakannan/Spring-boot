package com.onlinestore.project.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.onlinestore.project.Model.Customer;
@RestController
@RequestMapping("/customer")
public class customerController {

    List<Customer> listOfCutomer = new ArrayList<Customer>();
    
    {
     
        listOfCutomer.add(new Customer(1, "Karthik", "Chennai", "Karthik@gmail.com"));
        listOfCutomer.add(new Customer(2, "arun", "mumbai", "arun@gmail.com"));
        listOfCutomer.add(new Customer(3, "kowshik", "pune", "kowshik@gmail.com"));
        listOfCutomer.add(new Customer(4, "sri", "delhi", "sri@gmail.com"));
        listOfCutomer.add(new Customer(5, "don", "kolkata", "don@gmail.com"));

    }


    @PostMapping("/addCustomer")
    public String addCustomer(@RequestBody Customer customer)
    {
        listOfCutomer.add(customer);
        return "Sucessfully added customer:"+customer.getCus_id();
    }

    @GetMapping("/getCustomer")
    public List<Customer> viewCustomer()
    {
        return listOfCutomer;
    }

    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@PathVariable int id,@RequestBody Customer customer)
    {
        for(int i=0;i<listOfCutomer.size();i++)
        {
            if(listOfCutomer.get(i).getCus_id()==id)
            {
                listOfCutomer.add(i,customer);
                return listOfCutomer.get(i);
            }
        }
        return customer;
    }

    @DeleteMapping("/deleteCustomer")
    public Customer deleteCustomer(@RequestParam int id)
    {
        Customer cus=listOfCutomer.stream().filter(i->i.getCus_id()==id).findFirst().get();
        listOfCutomer.remove(cus);
        return cus;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/getByName")
    public List<Customer> getByName(@RequestParam("name") String name)
    {
        return listOfCutomer.stream().filter(i->i.getCus_name().equals(name)).collect(Collectors.toList());
    }

    @PatchMapping("/updateName")
    public List<Customer> updateByName(@RequestParam int id,@RequestParam String name) {
        listOfCutomer.stream().filter(i->i.getCus_id()==id).forEach(i->i.setCus_name(name));
        return listOfCutomer.stream().filter(i->i.getCus_id()==id).collect(Collectors.toList());
    }

    
}
