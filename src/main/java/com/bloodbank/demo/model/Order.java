package com.bloodbank.demo.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table
@Entity(name = "order")
public class Order {

    private static final long serialVersionUID = -1798070786993154586L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "status")
    private String status;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "price")
    private Long price;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "transfusion_date")
    private String transfusionDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
