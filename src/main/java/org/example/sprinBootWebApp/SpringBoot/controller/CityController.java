package org.example.sprinBootWebApp.SpringBoot.controller;

import org.example.sprinBootWebApp.SpringBoot.repos.CityRepository;
import org.example.sprinBootWebApp.SpringBoot.Model.City;
import org.example.sprinBootWebApp.SpringBoot.exeptions.ResourceNotFoundExeption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityRepository cityRepository;

    @GetMapping("/cities")
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = new ArrayList<City>();
        cityRepository.findAll().forEach(cities::add);
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable long id) {
        City city = cityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExeption("Not found Tutorial with id = " + id));

        return new ResponseEntity<>(city, HttpStatus.OK);
    }

    @PostMapping("/cities")
    public ResponseEntity<City> createCity(@RequestBody City city) {
        City _city = cityRepository.save(new City(city.getName()));
        return new ResponseEntity<>(_city, HttpStatus.CREATED);
    }

    @PutMapping("/cities/{id}")
    public ResponseEntity<City> updateCity(@PathVariable long id, @RequestBody City city) {
        City _city = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExeption("Not found Tutorial with id = " + id));

        _city.setName(city.getName());

        return new ResponseEntity<>(cityRepository.save(_city), HttpStatus.OK);
    }

    @DeleteMapping("/cities/{id}")
    public ResponseEntity<HttpStatus> deleteCity(@PathVariable long id) {
        cityRepository.deleteById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/cities")
    public ResponseEntity<HttpStatus> deleteAllTutorials() {
        cityRepository.deleteAll();

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
