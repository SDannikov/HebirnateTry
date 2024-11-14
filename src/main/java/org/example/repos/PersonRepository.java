package org.example.repos;

import org.example.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByCityId(Long postId);
    List<Person> findByCityName(String name);

    @Transactional
    void deleteByCityId(long cityId);

    @Transactional
    void deleteByCityNameContainingIgnoreCase(String cityName);
}
