package com.gmail.lilllung09.airlinereservation.controller;

import com.gmail.lilllung09.airlinereservation.state.AccountState;
import com.gmail.lilllung09.airlinereservation.object.AccountDTO;
import com.gmail.lilllung09.airlinereservation.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.regex.Pattern;

@Controller
public class AccountController {

    @Autowired
    AccountService accountService;

    //////////////////////////////////////////////////
    // 회원가입된 목록 조회가능한 페이지
    // ※실제 서비스시에는 지워야함
    //////////////////////////////////////////////////
    @GetMapping(value = "/dev/Accounts")
    public ModelAndView accounts() {
        ModelAndView mav = new ModelAndView("thymeleaf/develop/AccountInfoPage");

        List<AccountDTO> accounts = accountService.selectAll();
        mav.addObject("accounts", accounts);

        return mav;
    }

    //////////////////////////////////////////////////
    // 회원가입 페이지
    //////////////////////////////////////////////////
    @GetMapping(value = "/signUpPage")
    public ModelAndView signUpPage() {
        ModelAndView mav = new ModelAndView("thymeleaf/SignUpPage");

        List<AccountDTO> listDTO = accountService.selectAll();
        mav.addObject("listDTO", listDTO);

        return mav;
    }

    //////////////////////////////////////////////////
    // 로그인 페이지
    //////////////////////////////////////////////////
    @RequestMapping(value = "/signInPage")
    public ModelAndView signInPage(
            @RequestParam(required = false) String signInId
            ) {
        ModelAndView mav = new ModelAndView("thymeleaf/SignInPage");

        mav.addObject("signInId", signInId);

        return mav;
    }


    //////////////////////////////////////////////////
    // 회원가입 버튼 클릭시 airline/signUp으로 요청옴
    // 반환
    //     회원가입 불가 -> {"result":"0"}
    //     회원가입 완료 -> {"result":"1"}
    //////////////////////////////////////////////////
    @PostMapping(value = "/signUp")
    @ResponseBody
    public Object accountSignUp(
            @RequestBody AccountDTO accountDTO
            ) {

        AccountState accountState = getAccountState(accountDTO);
        if (!accountState.getAble()) {
            return "{\"result\":\"0\",\"state\":\"" + accountState.getState() + "\"}";
        }

        int result = accountService.signUp(accountDTO);
        return "{\"result\":\"" + result + "\",\"state\":\"" + (result==0 ? "unknown" : accountState.getState()) + "\"}";
    }

    private AccountState getAccountState(AccountDTO accountDTO) {
        String regex_id = "^[a-zA-Z0-9]*$";
        if (    accountDTO.getId() == null
            || accountDTO.getId().length() > 30
            || !Pattern.matches(regex_id, accountDTO.getId())) {

            return AccountState.InvalidID;
        }
        if (accountService.isDuplicated("id", accountDTO.getId())) {
            return AccountState.DuplicatedID;
        }

        String regex_pw = "^[a-zA-Z0-9]*$";
        if (    accountDTO.getPwOrigin() == null
            || accountDTO.getPwOrigin().length() > 200
            || accountDTO.getPwOrigin().length() < 5
            || !Pattern.matches(regex_pw, accountDTO.getPwOrigin())) {

            return AccountState.InvalidPW;
        }

        String regex_name = "^[a-zA-Z가-힣]*$";
        if (    accountDTO.getName() == null
            || accountDTO.getName().length() > 10
            || !Pattern.matches(regex_name, accountDTO.getName())) {

            return AccountState.InvalidNAME;
        }

        String regex_birth = "^(19|20)\\d{2}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[0-1])$";
        if (    accountDTO.getBirth() == null
            || !Pattern.matches(regex_birth, accountDTO.getBirth().toString())) {

            return AccountState.InvalidBIRTH;
        }

        String regex_ph = "^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$";
        if (    accountDTO.getPh() == null
            || !Pattern.matches(regex_ph, accountDTO.getPh())) {

            return AccountState.InvalidPH;
        }
        if (accountService.isDuplicated("ph", accountDTO.getPh())) {
            return AccountState.DuplicatedPH;
        }

        String regex_mail = "^[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\\.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$";
        if (    accountDTO.getMail() == null
            || !Pattern.matches(regex_mail, accountDTO.getMail())) {

            return AccountState.InvalidMAIL;
        }
        if (accountService.isDuplicated("mail", accountDTO.getMail())) {
            return AccountState.DuplicatedMAIL;
        }

        return AccountState.Normal;
    }
}
