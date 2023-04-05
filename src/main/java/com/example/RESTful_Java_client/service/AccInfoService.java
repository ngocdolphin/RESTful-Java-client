package com.example.RESTful_Java_client.service;

import com.example.RESTful_Java_client.entity.AccInfo;
import com.example.RESTful_Java_client.entity.AccInfoTemp;
import com.example.RESTful_Java_client.repository.AccInfoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccInfoService {

    private final AccInfoRepository repository;

    private final NetClientGet netClientGet;

    public List<AccInfo> getAll() {
        return repository.findAll();
    }

    public AccInfoTemp getAllAccInfo() throws JsonProcessingException {
        return netClientGet.getAllAccInfo();
    }

}
