package com.andy.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.hibernate.validator.constraints.Email;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "account")
@Table(name = "account")
public class Account {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Basic
    @NotNull (message = "Please enter a ema")
    @Email(message = "Please enter a valid email address")
    private String email;


    @Basic
    @NotNull (message = "Please enter a email")
    private String username;

    @NotNull (message = "Please enter a passsword")
    private String password;

    @OneToOne
    private Role role;


    @OneToOne
    @Cascade(CascadeType.ALL)
    private Customer customer;


    @OneToOne
    @Cascade(CascadeType.ALL)
    private Employee employee;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {

        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        this.password = hashedPassword;
    }


    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @PrePersist
    void presetUsername(){

        this.username = this.getEmail();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (email != null ? !email.equals(account.email) : account.email != null) return false;
        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;
        if (username != null ? !username.equals(account.username) : account.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}