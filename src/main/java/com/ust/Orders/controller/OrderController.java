package com.ust.Orders.controller;

import com.ust.Orders.entity.Order;
import com.ust.Orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/addorders")
public ResponseEntity <Order> addOrder(@RequestBody Order order){
        return new ResponseEntity<>(orderService.addOrder(order), HttpStatus.CREATED);
    }
    @GetMapping("/getorders")
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(),HttpStatus.OK);
    }
    @GetMapping("/getstatus/{status}")
    public ResponseEntity<List<Order>> getAllStatusOrders(@PathVariable String status){
        return new ResponseEntity<>(orderService.getAllStatusOrders(status),HttpStatus.OK);
    }
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id){
        Optional<Order> order=orderService.getOrderById(id);
        if(order.isPresent()){
            return new ResponseEntity<>(order.get(),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/getname/{name}")
    public ResponseEntity<List<Order>> getOrderByCustomerName(@PathVariable String name){
        return new ResponseEntity<>(orderService.getOrderByCustomerName(name),HttpStatus.OK);
    }
    @GetMapping("/getPrice/{min}/{max}")
    public ResponseEntity <List<Order>> getPriceBetween(@PathVariable  double min, @PathVariable double max){
    return new ResponseEntity<>(orderService.getByPriceBetween(min, max),HttpStatus.OK) ;
    }
}
