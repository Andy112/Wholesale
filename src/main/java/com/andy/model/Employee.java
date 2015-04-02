package com.andy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "employee", schema = "", catalog = "wholesaledeliverysystem")
public class Employee{

    @Id
    @Column(name = "employee_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String firstName;
    private String lastName;
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;


    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Basic
    @NotNull(message = "Please enter a firstname")
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @NotNull (message = "Please enter a lastname")
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Basic
    @Column(name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


    public void update(String firstName, String lastName, String location) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.location = location;
    }

}
