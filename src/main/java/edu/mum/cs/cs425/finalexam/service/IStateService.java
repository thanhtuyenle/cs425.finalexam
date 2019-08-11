package edu.mum.cs.cs425.finalexam.service;

import edu.mum.cs.cs425.finalexam.model.State;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IStateService {
    List<State> getAllStates();
    Page<State> getAllStates(int pageNo);
    State registerNewState(State State);
}
