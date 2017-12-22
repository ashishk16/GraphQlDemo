package com.example.DataFetcher;

import com.example.Models.Address;
import com.example.Models.Person;
import com.example.Repository.AddressRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
//public class  AddressDataFetcher implements DataFetcher<Address>{
//
//    @Autowired
//    AddressRepository addressRepository;
//
//    @Override
//    public Address get(DataFetchingEnvironment env) {
//        Person person = env.getSource();
//        return addressRepository.getAddress(person.getId());
//    }
//}
