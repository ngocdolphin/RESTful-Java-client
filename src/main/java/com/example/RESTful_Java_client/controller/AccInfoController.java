package com.example.RESTful_Java_client.controller;

import com.example.RESTful_Java_client.entity.AccInfo;
import com.example.RESTful_Java_client.service.AccInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/acc_info")
@RequiredArgsConstructor
public class AccInfoController {

    private final AccInfoService service;

    @GetMapping
    public List<AccInfo> getListAcc(){
        return service.getAll();
    }

    @GetMapping("/final_exam")
    public String getListAccFinalExam(){
        return service.getAllAcc();
    }
}
