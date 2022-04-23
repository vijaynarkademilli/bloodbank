package com.bloodbank.demo.service;

import com.bloodbank.demo.model.BloodDetails;
import com.bloodbank.demo.model.BloodDetailsUpdateModel;
import com.bloodbank.demo.model.User;
import com.bloodbank.demo.repository.BloodDetailsRepository;
import com.bloodbank.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BloodDetailsService {

    @Autowired
    private BloodDetailsRepository bloodDetailsRepository;

    @Autowired
    private UserRepository userRepository;


    public Long saveBloodDetails(BloodDetails bloodDetails){
        Long userId = bloodDetails.getUser().getUserId();
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            bloodDetails.setUser(user.get());
        }
        BloodDetails details = bloodDetailsRepository.save(bloodDetails);
        return details.getBloodId();
    }


    public List<BloodDetails> findByBloodGroup(String bloodGroup){
        return bloodDetailsRepository.findByBloodGroup(bloodGroup);
    }

    public List<BloodDetails> findAllBloodDetails(){
        return bloodDetailsRepository.findAll();
    }

    public void deleteById(Long id){
        Optional<BloodDetails> bloodDetails = bloodDetailsRepository.findById(id);
        if(bloodDetails.isPresent()){
            bloodDetailsRepository.deleteById(id);
        }else {
            throw new RuntimeException("BloodDetails does not exist");
        }
    }

    public Long updateBloodDetails(BloodDetailsUpdateModel bloodDetailsUpdateModel) {
        Long id = bloodDetailsUpdateModel.getBloodDetailsId();
        BloodDetails bloodDetails = bloodDetailsRepository.findById(id).get();
        if (Objects.nonNull(bloodDetails)) {
            bloodDetails.setStatus(bloodDetailsUpdateModel.getStatus());
            bloodDetailsRepository.save(bloodDetails);
        } else {
            throw new RuntimeException("Blood Details Not Found");
        }
        return bloodDetails.getBloodId();
    }




}
