package com.gmail.lilllung09.airlinereservation.service;

import com.gmail.lilllung09.airlinereservation.dto.TestDTO;
import com.gmail.lilllung09.airlinereservation.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {

    @Autowired
    public TestMapper mapper;

    public List<TestDTO> selectTest() {
        return mapper.selectTest();
    }
}
