package org.example.sprinBootWebApp.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city")
    private Set<Person> persons = new HashSet<>();

    public City(String name) {
        this.name = name;
    }

    public Set<Person> getPersons() {
        return this.persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public void addPersons(Person person) {
        person.setCity(this);
        this.persons.add(person);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
