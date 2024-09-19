package com.ust.Orders.service;

import com.ust.Orders.entity.Order;
import com.ust.Orders.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepo repo;

    public Order addOrder(Order order) {
        return repo.save(order);

    }


    public List<Order> getAllOrders() {
        return repo.findAll();
    }

    public List<Order> getAllStatusOrders(String status) {
        return repo.findAllByStatus(status);
    }


    public Optional<Order> getOrderById(Long id) {
        return repo.findById(id);
    }

    public List<Order> getOrderByCustomerName(String name) {
        return repo.findAllByCustomerName(name);
    }

    public List<Order> getByPriceBetween(double min, double max) {
       return repo.findByPriceBetween(min,max);

    }
}
