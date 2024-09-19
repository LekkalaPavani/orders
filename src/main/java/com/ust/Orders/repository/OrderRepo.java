package com.ust.Orders.repository;

import com.ust.Orders.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order,Long> {
    List<Order> findAllByStatus(String status);


    List<Order> findAllByCustomerName(String name);



    List<Order> findByPriceBetween(double min, double max);
}
