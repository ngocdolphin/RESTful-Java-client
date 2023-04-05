package com.example.RESTful_Java_client.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@NoArgsConstructor
public class AccInfoTemp {
    @JsonProperty("id")
    private int id;

    @JsonProperty("username")
    private String userName;

    @JsonProperty("fullName")
    private String fullName;

    @JsonProperty("role")
    private String role;
}
