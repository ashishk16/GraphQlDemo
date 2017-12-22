package com.example.Models;


import lombok.AllArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
public class Address {
    @Id
    String id;
    String street;
    String block;
    String region;
    String country;
    String zip;
}
