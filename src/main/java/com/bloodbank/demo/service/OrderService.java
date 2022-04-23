package com.bloodbank.demo.service;

import com.bloodbank.demo.model.Order;
import com.bloodbank.demo.model.User;
import com.bloodbank.demo.repository.OrderRepository;
import com.bloodbank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private UserRepository userRepository;


    public Long saveOrderDetails(Order order){
        Long userId = order.getUser().getUserId();
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            order.setUser(user.get());
        }
        Order details = orderRepository.save(order);
        return details.getOrderId();
    }


    public List<Order> findByStatus(String status){
        return orderRepository.findByStatus(status);
    }

    public List<Order> findAllOrders(){
        return orderRepository.findAll();
    }


}
