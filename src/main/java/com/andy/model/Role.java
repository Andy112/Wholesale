package com.andy.model;

import javax.persistence.*;

@Entity(name = "role")
@Table(name = "role")
public class Role {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Basic
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}