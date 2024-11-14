package org.example.repos;

import org.example.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    City findByNameContainingIgnoreCase(String name);

    boolean existsByNameContainingIgnoreCase(String name);
}
