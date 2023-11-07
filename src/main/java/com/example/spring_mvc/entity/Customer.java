package com.example.spring_mvc.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private Integer age;
    private String name;
    private String address;

    public Customer(Integer age, String name, String address) {
        this.age = age;
        this.name = name;
        this.address = address;
    }
}
