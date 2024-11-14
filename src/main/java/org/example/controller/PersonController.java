package org.example.controller;

import org.example.model.City;
import org.example.model.Person;
import org.example.repos.PersonRepository;
import org.example.exeptions.ResourceNotFoundExeption;
import org.example.repos.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersonsByCityName(String cityName) {
        if (!cityRepository.existsByNameContainingIgnoreCase(cityName)) {
            throw new ResourceAccessException("Not found Tutorial with id = " + cityName);
        }

        List<Person> people = personRepository.findByCityName(cityName);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Not found Person with id = " + id));

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> createPersonByCityName( String cityName, @RequestBody Person personRequest) {
        if (!cityRepository.existsByNameContainingIgnoreCase(cityName)) {
            throw new ResourceAccessException("Not found City with id = " + cityName);
        }

        City city = cityRepository.findByNameContainingIgnoreCase(cityName);

        personRequest.setCity(city);
        personRepository.save(personRequest);

        return new ResponseEntity<>(personRequest, HttpStatus.CREATED);
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable long id, @RequestBody Person personRequest) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("PersonId " + id + "not found"));

        person.setName(personRequest.getName());
        person.setSurname(personRequest.getSurname());
        person.setPatronymic(personRequest.getPatronymic());
        person.setYear(personRequest.getYear());
        person.setPhoneNumber(personRequest.getPhoneNumber());
        person.setCity(personRequest.getCity());

        return new ResponseEntity<>(personRepository.save(person), HttpStatus.OK);
    }

    @DeleteMapping("/persons/{id}")
    public ResponseEntity<HttpStatus> deletePerson(@PathVariable long id) {
        personRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/persons")
    public ResponseEntity<List<Person>> deleteAllPersonsOfCity( String cityName) {
        if (!cityRepository.existsByNameContainingIgnoreCase(cityName)) {
            throw new ResourceAccessException("Not found City with id = " + cityName);
        }

        personRepository.deleteByCityNameContainingIgnoreCase(cityName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
