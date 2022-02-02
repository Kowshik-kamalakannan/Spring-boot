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
import com.onlinestore.project.Model.Order;


@RestController
@RequestMapping("/order")
public class orderController {

    List<Order> orderList=new ArrayList<>();
    
    {
        orderList.add(new Order(1, "Dell",new Customer(3, "sam", "Chennai", "sam@gmail.com")));
        orderList.add(new Order(2, "HP",new Customer(3, "sam", "Chennai", "sam@gmail.com")));
        orderList.add(new Order(3, "Lenova",new Customer(3, "sam", "Chennai", "sam@gmail.com")));
        orderList.add(new Order(4, "Apple",new Customer(3, "sam", "Chennai", "sam@gmail.com")));
        orderList.add(new Order(5, "Asus",new Customer(3, "sam", "Chennai", "sam@gmail.com")));

    }

    @PostMapping("/addOrder")
    public String addOrder(@RequestBody Order order)
    {
        orderList.add(order);
        return "order added Sucessfully - id:"+order.getOrder_id();
    }

    @GetMapping("/viewOrder")
    public List<Order> viewOrders()
    {
        return orderList;
    }

    @PostMapping("/updateOrder/{id}")
    public Order updateOrder(@PathVariable int id,@RequestBody Order order)
    {
        for(int i=0;i<orderList.size();i++)
        {
            if(orderList.get(i).getOrder_id()==id)
            {
                orderList.add(i,order);
                return orderList.get(i);
            }
        }
        return order;
    }

    @DeleteMapping("/deleteOrder")
    public Order deleteOrder(@RequestBody int id)
    {
        Order ord=orderList.stream().filter(i->i.getOrder_id()==id).findFirst().get();
        orderList.remove(ord);
        return ord;
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping("/getByOrderName")
    public List<Order> getOrderByName(@RequestParam("orderdesc") String name)
    {
        return orderList.stream().filter(i->i.getOrder_desc().equals(name)).collect(Collectors.toList());
    }

    @PatchMapping("/updateOrderName")
    public List<Order> OrderByName(@RequestParam int id,@RequestParam String name) {
        orderList.stream().filter(i->i.getOrder_id()==id).forEach(i->i.setOrder_desc(name));
        return orderList.stream().filter(i->i.getOrder_id()==id).collect(Collectors.toList());
    }

    //param(key-value)
    @GetMapping(value="/param", params ="version=1")
    public List<Order> getByparam1()
    {
        return orderList;
    }

    @GetMapping(value="/param", params ="version=2")
    public int getByparam2()
    {
        return orderList.size();
    }

    //key-value(header)
    @GetMapping(value="/header",headers = "x-api-ver=1")
    public List<Order> getByHeader1()
    {
        return orderList;
    }

    @GetMapping(value="/header",headers = "x-api-ver=2")
    public int getByHeader2()
    {
        return orderList.size();
    }

    
    //accept
    @GetMapping(value="/produces" , produces = "application/app-v1+json")
    public List<Order> getByProduces1()
    {
        return orderList;
    }


    @GetMapping(value="/produces" , produces = "application/app-v2+json")
    public int getByProduces2()
    {
        return orderList.size();
    }




    
}
