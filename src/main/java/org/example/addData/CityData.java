package org.example.addData;

import com.google.gson.Gson;
import org.example.Model.HttpClientCityModel;
import org.example.requests.PostRequests;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityData {

    @Autowired
    PostRequests postRequests;

    @Autowired
    Gson gson;

    public void addCities(){
        try {
            postRequests.sendCity("http://localhost:9091/api/cities", gson.toJson(new HttpClientCityModel("Обнинск")));
            postRequests.sendCity("http://localhost:9091/api/cities", gson.toJson(new HttpClientCityModel("Москва")));
            postRequests.sendCity("http://localhost:9091/api/cities", gson.toJson(new HttpClientCityModel("Тунис")));
        } catch (Exception e) {
            System.out.println("Failed due http client processing.." + e.getMessage());
        }
    }
}
