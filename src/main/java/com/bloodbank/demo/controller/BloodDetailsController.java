package com.bloodbank.demo.controller;

import com.bloodbank.demo.model.BloodDetails;
import com.bloodbank.demo.model.BloodDetailsUpdateModel;
import com.bloodbank.demo.service.BloodDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BloodDetailsController {

    @Autowired
    private BloodDetailsService bloodDetailsService;

    @PostMapping("/saveBloodDetails")
    public ResponseEntity<BloodDetails> saveBloodDetails(@RequestBody BloodDetails bloodDetails){
        bloodDetailsService.saveBloodDetails(bloodDetails);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getBloodDetails/{bloodGroup}")
    public List<BloodDetails> getAllBloodDetailsByBloodGroup(@PathVariable("bloodGroup") String bloodGroup){
        return bloodDetailsService.findByBloodGroup(bloodGroup);
    }

    @GetMapping("/getAllBloodDetails")
    public List<BloodDetails> getAllBloodDetails(){
        return bloodDetailsService.findAllBloodDetails();
    }

    @PutMapping("/updateBloodDetails")
    public ResponseEntity<BloodDetails> updateBloodDetails(@RequestBody BloodDetailsUpdateModel bloodDetails){
        bloodDetailsService.updateBloodDetails(bloodDetails);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteBloodDetails/{bloodDetailsId}")
    public void deleteOrder(@PathVariable("bloodDetailsId") Long bloodDetailsId){
        bloodDetailsService.deleteById(bloodDetailsId);
    }


}
