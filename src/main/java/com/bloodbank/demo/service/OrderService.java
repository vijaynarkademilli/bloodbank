package com.bloodbank.demo.service;

import com.bloodbank.demo.model.Order;
import com.bloodbank.demo.model.OrderUpdateModel;
import com.bloodbank.demo.model.User;
import com.bloodbank.demo.repository.OrderRepository;
import com.bloodbank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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

    public void deleteById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        if(order.isPresent()){
            orderRepository.deleteById(id);
        }else {
            throw new RuntimeException("Order does not exist");
        }
    }

    public Long updateOrderDetails(OrderUpdateModel orderUpdateModel) {
        Long id = orderUpdateModel.getOrderId();
        Order order = orderRepository.findById(id).get();
        if (Objects.nonNull(order)) {
            order.setStatus(orderUpdateModel.getStatus());
            orderRepository.save(order);
        } else {
            throw new RuntimeException("Blood Details Not Found");
        }
        return order.getOrderId();
    }



}
