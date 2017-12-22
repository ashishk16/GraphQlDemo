package com.example.DataFetcher;

import com.example.Models.Person;
import com.example.Repository.PersonRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AllPeopleDataFetcher implements DataFetcher<List<Person>>{

    @Autowired
    PersonRepository personRepository;

    @Override
    public List<Person> get(DataFetchingEnvironment env) {
        return personRepository.findAll();
    }
}
