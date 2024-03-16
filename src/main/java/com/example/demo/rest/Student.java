package com.example.demo.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private String name;
    private Integer age;


    public static void main(String[] args) throws JsonProcessingException {
        Student student = new Student("Argen", 27);

        ObjectMapper mapper = new ObjectMapper();

        String jsonStudent = mapper.writeValueAsString(student);

        Student student1 = mapper.readValue(jsonStudent, Student.class);

        System.out.println(jsonStudent);

        System.out.println(student1.toString());
    }
}