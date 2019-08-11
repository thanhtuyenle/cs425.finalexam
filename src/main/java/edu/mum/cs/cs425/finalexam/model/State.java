package edu.mum.cs.cs425.finalexam.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="states")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stateId;

    @NotNull(message = "* State Code is required")
    @Column(name = "stateCode", nullable = false, unique = true)
    private String stateCode;

    @NotNull(message = "* State Name is required")
    @NotBlank(message = "* State Name cannot be empty or blank space(s)")
    private String stateName;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private List<Citizen> citizens = new ArrayList<>();

    public State(){

    }
    public State(@NotNull(message = "* Supplier Number is required") String stateCode, @NotNull(message = "* State Name is required") @NotBlank(message = "* State Name cannot be empty or blank space(s)") String stateName, List<Citizen> citizens) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.citizens = citizens;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public List<Citizen> getCitizens() {
        return citizens;
    }

    public void setCitizens(List<Citizen> citizens) {
        this.citizens = citizens;
    }

    @Override
    public String toString() {
        return "State{" +
                "stateId=" + stateId +
                ", stateCode='" + stateCode + '\'' +
                ", stateName='" + stateName + '\'' +
                ", citizens=" + citizens +
                '}';
    }
}
