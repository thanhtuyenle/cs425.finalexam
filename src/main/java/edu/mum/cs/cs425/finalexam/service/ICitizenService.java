package edu.mum.cs.cs425.finalexam.service;


import edu.mum.cs.cs425.finalexam.model.Citizen;

import java.util.List;

public interface ICitizenService {

    public List<Citizen> getAllCitizens();

    public Citizen addNewCitizen(Citizen Citizen);
    public Double computeTotalNationalYearlyIncome();
}
