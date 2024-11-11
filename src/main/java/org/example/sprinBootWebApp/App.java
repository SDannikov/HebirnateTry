package org.example.sprinBootWebApp;

import org.example.sprinBootWebApp.Model.City;
import org.example.sprinBootWebApp.Model.DAO.CityDAO;
import org.example.sprinBootWebApp.Model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


public class App {

    public static void main(String[] args) {

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        CityDAO cityDAO = new CityDAO();
        cityDAO.setSession(session);

        Transaction tx = session.beginTransaction();


        City city1 = new City("Обнинск");
        City city2 = new City("Москва");
        City city3 = new City("Тунис");

        city1.addPersons(new Person("Александр", "Смирнов", "Александрович", 1981, "0-000-000-00-00"));
        city1.addPersons(new Person("Михаил", "Иванов", "Иванович", 1999, "1-111-111-11-11"));
        city1.addPersons(new Person("Максим", "Кузнецов", "Васильевич", 2023, "2-222-222-22-22"));
        city1.addPersons(new Person("Лев", "Лебедев", "Августович", 2001, "3-333-333-33-33"));
        city1.addPersons(new Person("Марк", "Морозов", "Львович", 1993, "4-444-444-44-44"));
        city1.addPersons(new Person("Артем", "Соловьёв", "Магомедович", 1989, "5-555-555-55-55"));
        city1.addPersons(new Person("Матвей", "Васильев", "Евсеевич", 2012, "6-666-666-66-66"));
        city1.addPersons(new Person("Иван", "Семёнов", "Никифорович", 1986, "7-777-777-77-77"));
        city2.addPersons(new Person("Дмитрий", "Голубев", "Олегович", 1987, "8-888-888-88-88"));
        city2.addPersons(new Person("Тимофей", "Богданов", "Афанасьевич", 1998, "9-999-999-99-99"));
        city2.addPersons(new Person("София", "Михайлова", "Акимовна", 1980, "1-212-121-21-21"));
        city2.addPersons(new Person("Анна", "Беляева", "Денисовна", 1997, "1-313-131-31-31"));
        city2.addPersons(new Person("Иннокентий", "Ковалёв", "Романович", 2008, "1-414-141-41-41"));
        city2.addPersons(new Person("Мария", "Титова", "Никитовна", 2009, "1-515-151-51-51"));
        city2.addPersons(new Person("Ева", "Сергеева", "Никоновна", 2013, "1-616-161-61-61"));
        city2.addPersons(new Person("Виктория", "Герасимова", "Степановна", 2014, "1-717-171-71-71"));
        city3.addPersons(new Person("Варвара", "Мельникова", "Тельмановна", 1994, "1-818-181-81-81"));
        city3.addPersons(new Person("Ипполит", "Жданов", "Сильвестрович", 1995, "1-919-191-91-91"));
        city3.addPersons(new Person("Полина", "Дементьева", "Григорьевна", 1980, "2-121-212-12-12"));
        city3.addPersons(new Person("Алиса", "Субботина", "Ярославовна", 1997, "2-323-232-32-32"));
        city3.addPersons(new Person("Василиса", "Мамонтова", "Максимовна", 1986, "2-424-242-42-42"));
        city3.addPersons(new Person("Ярополк", "Овчинников", "Трофимович", 2005, "2-525-252-52-52"));
        city3.addPersons(new Person("Светлана", "Терентьева", "Константиновна", 1982, "2-626-262-62-62"));
        city3.addPersons(new Person("Александра", "Брагина", "Ильмировна", 1995, "2-727-272-72-72"));

        session.save(city1);
        session.save(city2);
        session.save(city3);

        tx.commit();
        session.close();
    }
}
