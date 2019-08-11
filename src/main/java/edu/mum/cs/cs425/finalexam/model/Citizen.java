package edu.mum.cs.cs425.finalexam.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="citizens")
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citizenId;

    @NotNull(message = "* Social Security Number is required")
    //@Digits(integer = 9, fraction = 0, message = "* Citizen number must be numeric; and a positive, integral value")
    @Column(name = "socialSecurityNumber", nullable = false, unique = true)
    private String socialSecurityNumber;

    @NotNull(message = "* First Name is required")
    @NotBlank(message = "* First Name cannot be empty or blank space(s)")
    private String firstName;

    private String middleName;

    @NotNull(message = "* Last Name is required")
    @NotBlank(message = "* Last Name cannot be empty or blank space(s)")
    private String lastName;

    @NotNull(message = "* Date Of Birth is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @NotNull(message = "* Yearly Income is required")
    @Digits(integer = 9, fraction = 2, message = "* Unit Price must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'")
    @NumberFormat(pattern = "#,###.##")
    private Double yearlyIncome;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "stateId", nullable = false)
    @NotNull(message = "* State is required")
    private State state;

    public Citizen(){

    }

    public Citizen(@NotNull(message = "* Social Security Number is required") String socialSecurityNumber, @NotNull(message = "* First Name is required") @NotBlank(message = "* First Name cannot be empty or blank space(s)") String firstName, String middleName, @NotNull(message = "* Last Name is required") @NotBlank(message = "* Last Name cannot be empty or blank space(s)") String lastName, @NotNull(message = "* Date Of Birth is required") LocalDate dateOfBirth, @NotNull(message = "* Yearly Income is required") @Digits(integer = 9, fraction = 2, message = "* Unit Price must be a numeric/monetary amount in decimal (money) format such as 'x,xxx.xx'") Double yearlyIncome, @NotNull(message = "* State is required") State state) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.yearlyIncome = yearlyIncome;
        this.state = state;
    }

    public Long getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Long citizenId) {
        this.citizenId = citizenId;
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public void setSocialSecurityNumber(String socialSecurityNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Double getYearlyIncome() {
        return yearlyIncome;
    }

    public void setYearlyIncome(Double yearlyIncome) {
        this.yearlyIncome = yearlyIncome;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "citizenId=" + citizenId +
                ", socialSecurityNumber='" + socialSecurityNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", yearlyIncome=" + yearlyIncome +
                ", state=" + state +
                '}';
    }
}
