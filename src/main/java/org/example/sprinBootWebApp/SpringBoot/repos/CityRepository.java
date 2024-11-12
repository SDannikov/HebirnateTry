package org.example.sprinBootWebApp.SpringBoot.repos;

import org.example.sprinBootWebApp.SpringBoot.Model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {
}
