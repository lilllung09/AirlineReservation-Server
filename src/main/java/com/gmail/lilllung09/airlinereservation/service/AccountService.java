package com.gmail.lilllung09.airlinereservation.service;

import com.gmail.lilllung09.airlinereservation.mapper.AccountMapper;
import com.gmail.lilllung09.airlinereservation.object.AccountDTO;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class AccountService {

    @Autowired
    public AccountMapper mapper;

    public List<AccountDTO> selectAll() {
        return mapper.selectAll();
    }

    public int signUp(AccountDTO account) {
        try {
            return mapper.signUp(account);

        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public boolean isDuplicated(String column, String data) {
        return mapper.isDuplicated(column, data).size() > 0;
    }


}
