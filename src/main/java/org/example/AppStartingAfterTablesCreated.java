package org.example;


import org.example.model.City;
import org.example.model.Person;
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

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if(cityRepository.count() == 0){
            cityRepository.save(new City("Обнинск"));
            cityRepository.save(new City("Москва"));
            cityRepository.save(new City("Тунис"));

        }

        if (personRepository.count() == 0){
            savePerson(new Person("Александр", "Смирнов", "Александрович", 1981, "0-000-000-00-00"), "Москва");
            savePerson(new Person("Михаил", "Иванов", "Иванович", 1999, "1-111-111-11-11"), "Обнинск");
            savePerson(new Person("Максим", "Кузнецов", "Васильевич", 2023, "2-222-222-22-22"), "Москва");
            savePerson(new Person("Лев", "Лебедев", "Августович", 2001, "3-333-333-33-33"), "Тунис");
            savePerson(new Person("Марк", "Морозов", "Львович", 1993, "4-444-444-44-44"), "Обнинск");
            savePerson(new Person("Артем", "Соловьёв", "Магомедович", 1989, "5-555-555-55-55"), "тунис");
            savePerson(new Person("Матвей", "Васильев", "Евсеевич", 2012, "6-666-666-66-66"), "Москва");
            savePerson(new Person("Иван", "Семёнов", "Никифорович", 1986, "7-777-777-77-77"), "Обнинск");
            savePerson(new Person("Дмитрий", "Голубев", "Олегович", 1987, "8-888-888-88-88"), "Обнинск");
            savePerson(new Person("Тимофей", "Богданов", "Афанасьевич", 1998, "9-999-999-99-99"), "Москва");
            savePerson(new Person("София", "Михайлова", "Акимовна", 1980, "1-212-121-21-21"), "Тунис");
            savePerson(new Person("Анна", "Беляева", "Денисовна", 1997, "1-313-131-31-31"), "Обнинск");
            savePerson(new Person("Иннокентий", "Ковалёв", "Романович", 2008, "1-414-141-41-41"), "Тунис");
            savePerson(new Person("Мария", "Титова", "Никитовна", 2009, "1-515-151-51-51"), "тунис");
            savePerson(new Person("Ева", "Сергеева", "Никоновна", 2013, "1-616-161-61-61"), "Москва");
            savePerson(new Person("Виктория", "Герасимова", "Степановна", 2014, "1-717-171-71-71"), "Тунис");
            savePerson(new Person("Варвара", "Мельникова", "Тельмановна", 1994, "1-818-181-81-81"), "обнинск");
            savePerson(new Person("Ипполит", "Жданов", "Сильвестрович", 1995, "1-919-191-91-91"), "Тунис");
            savePerson(new Person("Полина", "Дементьева", "Григорьевна", 1980, "2-121-212-12-12"), "москва");
            savePerson(new Person("Алиса", "Субботина", "Ярославовна", 1997, "2-323-232-32-32"), "москва");
            savePerson(new Person("Василиса", "Мамонтова", "Максимовна", 1986, "2-424-242-42-42"), "Москва");
            savePerson(new Person("Ярополк", "Овчинников", "Трофимович", 2005, "2-525-252-52-52"), "Обнинск");
            savePerson(new Person("Светлана", "Терентьева", "Константиновна", 1982, "2-626-262-62-62"), "обнинск");
            savePerson(new Person("Александра", "Брагина", "Ильмировна", 1995, "2-727-272-72-72"), "Тунис");
        }
    }

    private void savePerson(Person person, String cityName){
        person.setCity(cityRepository.findByNameContainingIgnoreCase(cityName));

        personRepository.save(person);
    }
}
