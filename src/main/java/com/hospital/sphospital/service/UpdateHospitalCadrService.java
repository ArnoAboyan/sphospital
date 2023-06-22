package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.HospitalCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UpdateHospitalCadrService {
    @Autowired
    HospitalCardRepository hospitalCardRepository;

    HospitalCard hospitalCard;


    @Transactional
    public Boolean updateHospitalCard(int hospitalCardId, String procedures, String medications, String operations, String diagnosis) throws CommandException {



        hospitalCard =  hospitalCardRepository.findById(hospitalCardId).orElseThrow(() -> new NullPointerException("HospitalCard not found"));

        System.out.println("FIND HOSPITAL CARD => " +  hospitalCard);

       hospitalCard.setProcedures(procedures);
       hospitalCard.setOperations(operations);
       hospitalCard.setMedications(medications);
       hospitalCard.setDiagnosis(diagnosis);

        hospitalCardRepository.save(hospitalCard);

        return true;
    }


    public HospitalCard actualHospitalCard(){
        return hospitalCard;
    }


//    public Boolean updateHospitalCard(HospitalCard hospitalCard) throws CommandException {
//        if (!hospitalCardRepository.existsById(hospitalCard.getHospitalCardId())) {
//            throw new CommandException("Doctor not found");
//        }
//        hospitalCardRepository.save(hospitalCard);
//
//        return true;
//    }

}
