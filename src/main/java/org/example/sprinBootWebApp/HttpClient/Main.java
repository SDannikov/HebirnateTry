package org.example.sprinBootWebApp.HttpClient;

import com.google.gson.Gson;
import org.example.sprinBootWebApp.HttpClient.model.City;
import org.example.sprinBootWebApp.HttpClient.model.Person;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public String sendCity(String urlStr, String json) throws Exception {
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        connection.setDoOutput(true);

        getOutputStream(connection, json);

        StringBuilder sb = new StringBuilder();

        sb = getInputStream(connection, sb);

        return sb.toString();
    }

    public String sendPerson(String urlStr, String json, Integer cityId) throws Exception {
        URL url = new URL(urlStr + "/" + cityId + "/persons");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
        connection.setDoOutput(true);

        getOutputStream(connection, json);

        StringBuilder sb = new StringBuilder();

        sb = getInputStream(connection, sb);

        return sb.toString();
    }

    public static void main(String[] args) {
        try {

            Gson gson = new Gson();
            new Main().sendCity("http://localhost:9091/api/cities", gson.toJson(new City("Обнинск")));
            new Main().sendCity("http://localhost:9091/api/cities", gson.toJson(new City("Москва")));
            new Main().sendCity("http://localhost:9091/api/cities", gson.toJson(new City("Тунис")));

            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Александр", "Смирнов", "Александрович", 1981, "0-000-000-00-00")), 1);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Михаил", "Иванов", "Иванович", 1999, "1-111-111-11-11")), 2);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Максим", "Кузнецов", "Васильевич", 2023, "2-222-222-22-22")), 3);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Лев", "Лебедев", "Августович", 2001, "3-333-333-33-33")), 3);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Марк", "Морозов", "Львович", 1993, "4-444-444-44-44")), 2);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Артем", "Соловьёв", "Магомедович", 1989, "5-555-555-55-55")), 1);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Матвей", "Васильев", "Евсеевич", 2012, "6-666-666-66-66")), 1);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Иван", "Семёнов", "Никифорович", 1986, "7-777-777-77-77")), 2);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Дмитрий", "Голубев", "Олегович", 1987, "8-888-888-88-88")), 3);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Тимофей", "Богданов", "Афанасьевич", 1998, "9-999-999-99-99")), 3);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("София", "Михайлова", "Акимовна", 1980, "1-212-121-21-21")), 2);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Анна", "Беляева", "Денисовна", 1997, "1-313-131-31-31")), 1);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Иннокентий", "Ковалёв", "Романович", 2008, "1-414-141-41-41")), 1);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Мария", "Титова", "Никитовна", 2009, "1-515-151-51-51")), 2);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Ева", "Сергеева", "Никоновна", 2013, "1-616-161-61-61")), 3);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Виктория", "Герасимова", "Степановна", 2014, "1-717-171-71-71")), 3);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Варвара", "Мельникова", "Тельмановна", 1994, "1-818-181-81-81")), 2);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Ипполит", "Жданов", "Сильвестрович", 1995, "1-919-191-91-91")), 1);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Полина", "Дементьева", "Григорьевна", 1980, "2-121-212-12-12")), 1);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Алиса", "Субботина", "Ярославовна", 1997, "2-323-232-32-32")), 2);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Василиса", "Мамонтова", "Максимовна", 1986, "2-424-242-42-42")), 3);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Ярополк", "Овчинников", "Трофимович", 2005, "2-525-252-52-52")), 3);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Светлана", "Терентьева", "Константиновна", 1982, "2-626-262-62-62")), 2);
            new Main().sendPerson("http://localhost:9091/api/cities", gson.toJson(new Person("Александра", "Брагина", "Ильмировна", 1995, "2-727-272-72-72")), 1);



        } catch (Exception e) {
            System.out.println("Failed due http client processing.." + e.getMessage());
        }
    }

    private static void getOutputStream(HttpURLConnection connection, String json) throws IOException {
        try (OutputStream os = new BufferedOutputStream(connection.getOutputStream())) {
            byte[] bytes = json.getBytes("UTF-8");

            os.write(bytes, 0, bytes.length);
        }
    }

    private static StringBuilder getInputStream(HttpURLConnection connection, StringBuilder sb) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line = null;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }
        return sb;
    }
}
