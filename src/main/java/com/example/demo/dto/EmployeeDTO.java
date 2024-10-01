package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public record EmployeeDTO(@JsonProperty("id")
                          Long id,
                          @JsonProperty("surname")
                          String surname,
                          @JsonProperty("name")
                          String name,
                          @JsonProperty("middleName")
                          String middleName,
                          @JsonProperty("status")
                          String status){}
