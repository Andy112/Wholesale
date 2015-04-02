package com.andy.model;

import javax.persistence.*;


@Entity
@Table(name = "customer", schema = "", catalog = "wholesaledeliverysystem")
public class Customer {


    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Basic
    @Column(name = "firstName")
    private String firstName;

    @Basic
    @Column(name = "lastName")
    private String lastName;

    @Basic
    @Column(name = "address")
    private String address;

    @Basic
    @Column(name = "telephone")
    private String telephone;

    @Basic
    @Column(name = "gender")
    private String gender;

    @Basic
    @Column(name = "dob")
    private String dob;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    //TODO change to date
    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }


}
