package com.example.RESTful_Java_client.repository;

import com.example.RESTful_Java_client.entity.AccInfo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccInfoRepository extends JpaRepository<AccInfo, Integer> {
}
