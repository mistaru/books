package com.example.demo.controller;

import com.example.demo.dto.Employee;
import com.example.demo.dto.Employee2;
import com.example.demo.dto.Response;
import com.example.demo.dto.ResponseList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
class MyController {
    private final RestTemplate restTemplate;

    public MyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/employees")
    public ResponseList<Employee> getEmployees() throws JsonProcessingException {
        String apiUrl = "https://dummy.restapiexample.com/api/v1/employees";
        String jsonEmployees =  restTemplate.getForObject(apiUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();
        ResponseList<Employee> listEmployees = mapper.readValue(jsonEmployees, ResponseList.class);

        return listEmployees;
    }

    @GetMapping("/employee/{id}")
    public Response<Employee> getEmployeeById(@PathVariable Long id) throws JsonProcessingException {
        String apiUrl = "https://dummy.restapiexample.com/api/v1/employee/1";
        String jsonEmployee =  restTemplate.getForObject(apiUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response<Employee> employee = mapper.readValue(jsonEmployee, Response.class);

        return employee;
    }

    @PostMapping("/create")
    public String createEmployee(@RequestBody String requestBody) {
        String apiUrl = "https://dummy.restapiexample.com/api/v1/create";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        return restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class).getBody();
    }
}

