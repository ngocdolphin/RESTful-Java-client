package com.example.RESTful_Java_client.service;

import com.example.RESTful_Java_client.entity.AccInfoTemp;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Map;


@Service
@RequiredArgsConstructor
public class NetClientGet {
    private final RestTemplate restTemplate;

    public AccInfoTemp netClientGet(){

        try {
            URL url = new URL("http://localhost:8080/api/v1/accounts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            String password = "123456";
            String username = "dangblack";
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
            String authHeaderValue = "Basic " + new String(encodedAuth);
            conn.setRequestProperty ("Authorization", authHeaderValue);

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String output;
            while ((output = br.readLine()) != null) {
                ObjectMapper mapper = new ObjectMapper();
                Map<String, Object> objectMap = mapper.readValue(output, Map.class);

                AccInfoTemp accInfoTemp = mapper.readValue(output, AccInfoTemp.class);

                return accInfoTemp;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
        return null;
    }

    public AccInfoTemp getAllAccInfo() throws JsonProcessingException {
        String url = "http://localhost:8080/api/v1/accounts";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        String password = "123456";
        String username = "dangblack";
        headers.setBasicAuth(username, password);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        String output = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> objectMap = mapper.readValue(output, Map.class);

        AccInfoTemp accInfoTemp = restTemplate.getForObject(url, AccInfoTemp.class, objectMap);
        return accInfoTemp;
    }

}
