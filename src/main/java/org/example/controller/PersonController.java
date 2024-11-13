package org.example.controller;

import org.example.Model.City;
import org.example.Model.Person;
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

    @GetMapping("/cities/{cityId}/persons")
    public ResponseEntity<List<Person>> getAllPersonsByCityId(@PathVariable Long cityId) {
        if (!cityRepository.existsById(cityId)) {
            throw new ResourceAccessException("Not found Tutorial with id = " + cityId);
        }

        List<Person> people = personRepository.findByCityId(cityId);
        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<Person> getPersonByCityId(@PathVariable Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Not found Person with id = " + id));

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @PostMapping("/cities/{cityId}/persons")
    public ResponseEntity<Person> createPersonByCityId(@PathVariable Long cityId, @RequestBody Person personRequest) {
        Person person = cityRepository.findById(cityId).map(cityModel -> {
            personRequest.setCity(cityModel);
            return personRepository.save(personRequest);
        }).orElseThrow(() -> new ResourceNotFoundExeption("Not found City with id = " + cityId));

        return new ResponseEntity<>(person, HttpStatus.CREATED);
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

    @DeleteMapping("/cities/{cityId}/persons")
    public ResponseEntity<List<Person>> deleteAllPersonsOfCity(@PathVariable Long cityId) {
        if (!cityRepository.existsById(cityId)) {
            throw new ResourceAccessException("Not found Tutorial with id = " + cityId);
        }

        personRepository.deleteByCityId(cityId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
