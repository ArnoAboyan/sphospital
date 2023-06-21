package com.hospital.sphospital.service;

import com.hospital.sphospital.entity.HospitalCard;
import com.hospital.sphospital.exeption.CommandException;
import com.hospital.sphospital.repositorie.HospitalCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateHospitalCadrService {
    @Autowired
    HospitalCardRepository hospitalCardRepository;

    public Boolean updateHospitalCard(HospitalCard hospitalCard) throws CommandException {
        if (!hospitalCardRepository.existsById(hospitalCard.getHospitalCardId())) {
            throw new CommandException("Doctor not found");
        }
        hospitalCardRepository.save(hospitalCard);

        return true;
    }

}
