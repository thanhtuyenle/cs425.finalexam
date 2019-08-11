package edu.mum.cs.cs425.finalexam.service.impl;



import edu.mum.cs.cs425.finalexam.model.Citizen;
import edu.mum.cs.cs425.finalexam.repository.ICitizenRepository;
import edu.mum.cs.cs425.finalexam.service.ICitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitizenServiceImpl implements ICitizenService {

    @Autowired
    private ICitizenRepository citizenRepository;


    @Override
    public List<Citizen> getAllCitizens() {
        return citizenRepository.findAll(Sort.by("lastName"));
    }

    @Override
    public Citizen addNewCitizen(Citizen Citizen) {
        return citizenRepository.save(Citizen);
    }

    @Override
    public Double computeTotalNationalYearlyIncome() {
        Double income = 0.0;
        List<Citizen> citizens = citizenRepository.findAll();
        for(Citizen citizen : citizens) {
            income += citizen.getYearlyIncome();
        }
        return income;
    }
}
