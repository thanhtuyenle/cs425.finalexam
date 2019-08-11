package edu.mum.cs.cs425.finalexam.service.impl;

import edu.mum.cs.cs425.finalexam.model.State;
import edu.mum.cs.cs425.finalexam.repository.IStateRepository;
import edu.mum.cs.cs425.finalexam.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements IStateService {

    @Autowired
    private IStateRepository stateRepository;

    @Override
    public List<State> getAllStates() {
        return stateRepository.findAll(Sort.by("stateName"));
    }

    @Override
    public Page<State> getAllStates(int pageNo) {
        return stateRepository.findAll(PageRequest.of(pageNo, 3, Sort.by("stateName")));
    }

    @Override
    public State registerNewState(State State) {
        return stateRepository.save(State);
    }

}
