package com.bloodbank.demo.model;

import lombok.Data;

@Data
public class OrderUpdateModel {

    private Long orderId;
    private String status;

}
