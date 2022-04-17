package com.bloodbank.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Table
@Entity(name = "blood_details")
public class BloodDetails implements Serializable {

    private static final long serialVersionUID = -1798070786993154686L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "blood_id")
    private Long bloodId;

    @Column(name = "donation_date")
    private String donationDate;

    @Column(name = "blood_group")
    private String bloodGroup;

    @Column(name = "donor")
    private String donor;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
