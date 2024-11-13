package org.example;


import org.example.addData.CityData;
import org.example.addData.PersonData;
import org.example.repos.CityRepository;
import org.example.repos.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppStartingAfterTablesCreated implements ApplicationRunner {

    @Autowired
    CityRepository cityRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    CityData cityData;

    @Autowired
    PersonData personData;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if(cityRepository.count() == 0){
            cityData.addCities();
        }

        if (personRepository.count() == 0){
            personData.addPerson();
        }
    }
}
