package com.example.demo.controller;

import com.example.demo.dto.Employee;
import com.example.demo.dto.Employee2;
import com.example.demo.dto.Response;
import com.example.demo.dto.ResponseList;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
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
        String apiUrl = "https://dummy.restapiexample.com/api/v1/employee/" + id;

        String jsonEmployee =  restTemplate.getForObject(apiUrl, String.class);

        ObjectMapper mapper = new ObjectMapper();
        Response<Employee> employee = mapper.readValue(jsonEmployee, Response.class);

        return employee;
    }

    @PostMapping("/create")
    public Response<Employee> createEmployee(@RequestBody String requestBody) throws JsonProcessingException {
        String apiUrl = "https://dummy.restapiexample.com/api/v1/create";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        String json = restTemplate.exchange(apiUrl, HttpMethod.POST, request, String.class).getBody();

        ObjectMapper mapper = new ObjectMapper();
        Response<Employee> employee = mapper.readValue(json, Response.class);
        return employee;
    }

    @PostMapping("/update/{id}")
    public Response<Employee> updateEmployee(@PathVariable Long id, @RequestBody String requestBody) throws JsonProcessingException {
        String apiUrl = "https://dummy.restapiexample.com/api/v1/update/" + id;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(requestBody, headers);

        String json = restTemplate.exchange(apiUrl, HttpMethod.PUT, request, String.class).getBody();

        ObjectMapper mapper = new ObjectMapper();
        Response<Employee> employee = mapper.readValue(json, Response.class);
        return employee;
    }

    @GetMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id) throws JsonProcessingException {
        String apiUrl = "https://dummy.restapiexample.com/api/v1/delete/" + id;

        String jsonEmployee = "";
        try {
            jsonEmployee =  restTemplate.getForObject(apiUrl, String.class);
            System.out.println(jsonEmployee);
        } catch (Exception e ) {

            e.getMessage();
        }

        return jsonEmployee;
    }
}

