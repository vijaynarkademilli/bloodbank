package com.bloodbank.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@Table
@Entity(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = -1798070786993154676L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String fullName;

    @Column(name = "user_type")
    private String userType;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "house_no")
    private String houseNo;

    @Column(name = "street")
    private String street;

    @Column(name = "city")
    private String city;

    @Column(name = "pin")
    private String pin;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<BloodDetails> bloodDetails = new HashSet<>();


}
