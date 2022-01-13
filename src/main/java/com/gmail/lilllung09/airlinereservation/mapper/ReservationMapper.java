package com.gmail.lilllung09.airlinereservation.mapper;

import com.gmail.lilllung09.airlinereservation.object.AccountDTO;
import com.gmail.lilllung09.airlinereservation.sql.AccountSQL;
import com.gmail.lilllung09.airlinereservation.sql.ReservationSQL;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReservationMapper {

}
