package com.example.demo.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public class Car    {
    String name;
    Integer age;

    public Car() {
    }

    public Car(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws JsonProcessingException {
        Car myCar = new Car("BMW", 2002);

        ObjectMapper mapper = new ObjectMapper();

        String jsonMyCar = mapper.writeValueAsString(myCar);

        System.out.println(jsonMyCar);

        String json = "{ \"name\" : \"BMW\", \"age\" : 2002}";

        Car againMyCar =mapper.readValue(jsonMyCar, Car.class);

        System.out.println(againMyCar.toString());



    }

}
