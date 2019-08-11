package edu.mum.cs.cs425.finalexam.repository;

import edu.mum.cs.cs425.finalexam.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository extends JpaRepository<State, Integer> {
}
