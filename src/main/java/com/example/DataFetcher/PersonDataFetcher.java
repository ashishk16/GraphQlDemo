package com.example.DataFetcher;

import com.example.Models.Person;
import com.example.Repository.PersonRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class PersonDataFetcher implements DataFetcher<Person>{

    @Autowired
    PersonRepository personRepository;

    @Override
    public Person get(DataFetchingEnvironment env) {
        Map arguments = env.getArguments();
        return personRepository.findOne((String) arguments.get("id"));
    }
}
