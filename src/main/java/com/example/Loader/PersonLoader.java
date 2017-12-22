package com.example.Loader;

import com.example.Models.Person;
import com.example.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class PersonLoader {
    @Autowired
    PersonRepository personRepository;

    @PostConstruct
    public void loadPerson(){
        personRepository.save(new Person("1","Adam","Lim",30));
        personRepository.save(new Person("2","Bella","Ten",12));
    }
}
