package com.gmail.lilllung09.airlinereservation.mapper;

import com.gmail.lilllung09.airlinereservation.dto.TestDTO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    List<TestDTO> selectTest();
}
