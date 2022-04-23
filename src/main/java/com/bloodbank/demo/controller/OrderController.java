package com.bloodbank.demo.controller;

import com.bloodbank.demo.model.BloodDetails;
import com.bloodbank.demo.model.Order;
import com.bloodbank.demo.model.OrderUpdateModel;
import com.bloodbank.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/getOrderDetails/{orderStatus}")
    public List<Order> getAllBloodDetailsByStatus(@PathVariable("orderStatus") String orderStatus){
        return orderService.findByStatus(orderStatus);
    }

    @GetMapping("/getAllOrderDetails")
    public List<Order> getAllOrders(){
        return orderService.findAllOrders();
    }

    @PostMapping("/saveOrderDetails")
    public ResponseEntity<Order> saveOrderDetails(@RequestBody Order order){
        orderService.saveOrderDetails(order);
        return ResponseEntity.ok().build();
    }


    @PutMapping("/updateOrderDetails")
    public ResponseEntity<BloodDetails> updateOrderDetails(@RequestBody OrderUpdateModel order){
        orderService.updateOrderDetails(order);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable("orderId") Long orderId){
        orderService.deleteById(orderId);
    }

}
