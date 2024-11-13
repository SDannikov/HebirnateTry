package org.example.repos;

import org.example.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByCityId(Long postId);

    @Transactional
    void deleteByCityId(long tutorialId);
}
