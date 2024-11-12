package org.example.sprinBootWebApp.SpringBoot.repos;

import org.example.sprinBootWebApp.SpringBoot.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
