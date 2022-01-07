package com.gmail.lilllung09.airlinereservation.mapper;

import com.gmail.lilllung09.airlinereservation.object.AccountDTO;
import com.gmail.lilllung09.airlinereservation.sql.AccountSQL;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface AccountMapper {

    @Select(AccountSQL.SELECT_ALL)
    List<AccountDTO> selectAll();

    @InsertProvider(type = AccountSQL.class, method = "signupAccount")
    int signUp(
            @Param("account") AccountDTO account
    );

    @SelectProvider(type = AccountSQL.class, method = "isDuplicated")
    List<AccountDTO> isDuplicated(
            @Param("column") String column,
            @Param("data") String data
    );
}
