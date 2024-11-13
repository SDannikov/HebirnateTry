package org.example.Model;

public class HttpClientCityModel {

    private Long id;

    private String name;


    public HttpClientCityModel(){}

    public HttpClientCityModel(String name) {
        this.name = name;
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
