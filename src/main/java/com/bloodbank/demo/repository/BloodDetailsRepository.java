package com.bloodbank.demo.repository;

import com.bloodbank.demo.model.BloodDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BloodDetailsRepository extends JpaRepository<BloodDetails, Long> {

    List<BloodDetails> findByBloodGroup(String bloodGroup);

}
