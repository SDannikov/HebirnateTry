package org.example.addData;

import com.google.gson.Gson;
import org.example.Model.HttpClientPersonModel;
import org.example.repos.CityRepository;
import org.example.requests.PostRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PersonData {

    @Autowired
    PostRequests postRequests;

    @Autowired
    Gson gson;

    @Autowired
    CityRepository cityRepository;

    public void addPerson() {
        try {
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Александр", "Смирнов", "Александрович", 1981, "0-000-000-00-00")), cityRepository.findByNameContainingIgnoreCase("Москва").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Михаил", "Иванов", "Иванович", 1999, "1-111-111-11-11")), cityRepository.findByNameContainingIgnoreCase("Обнинск").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Максим", "Кузнецов", "Васильевич", 2023, "2-222-222-22-22")), cityRepository.findByNameContainingIgnoreCase("Москва").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Лев", "Лебедев", "Августович", 2001, "3-333-333-33-33")), cityRepository.findByNameContainingIgnoreCase("Обнинск").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Марк", "Морозов", "Львович", 1993, "4-444-444-44-44")), cityRepository.findByNameContainingIgnoreCase("Москва").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Артем", "Соловьёв", "Магомедович", 1989, "5-555-555-55-55")), cityRepository.findByNameContainingIgnoreCase("Обнинск").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Матвей", "Васильев", "Евсеевич", 2012, "6-666-666-66-66")), cityRepository.findByNameContainingIgnoreCase("Тунис").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Иван", "Семёнов", "Никифорович", 1986, "7-777-777-77-77")), cityRepository.findByNameContainingIgnoreCase("Москва").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Дмитрий", "Голубев", "Олегович", 1987, "8-888-888-88-88")), cityRepository.findByNameContainingIgnoreCase("Тунис").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Тимофей", "Богданов", "Афанасьевич", 1998, "9-999-999-99-99")), cityRepository.findByNameContainingIgnoreCase("москва").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("София", "Михайлова", "Акимовна", 1980, "1-212-121-21-21")), cityRepository.findByNameContainingIgnoreCase("обнинск").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Анна", "Беляева", "Денисовна", 1997, "1-313-131-31-31")), cityRepository.findByNameContainingIgnoreCase("Москва").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Иннокентий", "Ковалёв", "Романович", 2008, "1-414-141-41-41")), cityRepository.findByNameContainingIgnoreCase("Тунис").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Мария", "Титова", "Никитовна", 2009, "1-515-151-51-51")), cityRepository.findByNameContainingIgnoreCase("Тунис").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Ева", "Сергеева", "Никоновна", 2013, "1-616-161-61-61")), cityRepository.findByNameContainingIgnoreCase("Обнинск").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Виктория", "Герасимова", "Степановна", 2014, "1-717-171-71-71")), cityRepository.findByNameContainingIgnoreCase("Тунис").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Варвара", "Мельникова", "Тельмановна", 1994, "1-818-181-81-81")), cityRepository.findByNameContainingIgnoreCase("тунис").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Ипполит", "Жданов", "Сильвестрович", 1995, "1-919-191-91-91")), cityRepository.findByNameContainingIgnoreCase("Москва").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Полина", "Дементьева", "Григорьевна", 1980, "2-121-212-12-12")), cityRepository.findByNameContainingIgnoreCase("Москва").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Алиса", "Субботина", "Ярославовна", 1997, "2-323-232-32-32")), cityRepository.findByNameContainingIgnoreCase("Тунис").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Василиса", "Мамонтова", "Максимовна", 1986, "2-424-242-42-42")), cityRepository.findByNameContainingIgnoreCase("Обнинск").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Ярополк", "Овчинников", "Трофимович", 2005, "2-525-252-52-52")), cityRepository.findByNameContainingIgnoreCase("Обнинск").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Светлана", "Терентьева", "Константиновна", 1982, "2-626-262-62-62")), cityRepository.findByNameContainingIgnoreCase("Тунис").getId());
            postRequests.sendPersonByCityId("http://localhost:9091/api/cities", gson.toJson(new HttpClientPersonModel("Александра", "Брагина", "Ильмировна", 1995, "2-727-272-72-72")), cityRepository.findByNameContainingIgnoreCase("Обнинск").getId());
        } catch (Exception e) {
            System.out.println("Failed due http client processing.." + e.getMessage());
        }
    }
}

