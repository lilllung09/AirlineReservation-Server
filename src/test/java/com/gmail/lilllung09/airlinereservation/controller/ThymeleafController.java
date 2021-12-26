package com.gmail.lilllung09.airlinereservation.controller;

import com.gmail.lilllung09.airlinereservation.vo.TestVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping(value = "/thymeleafTest1", method = RequestMethod.GET)
    public String thymeleafTest1(Model model) {
        model.addAttribute("greeting", "안녕하세요(행동)");

        return "thymeleaf/thymeleafTest1";
    }

    @RequestMapping(value = "/thymeleafTest2", method = RequestMethod.GET)
    public String thymeleafTest2(Model model) {
        TestVO testVO = new TestVO("lilllung09", "pilljoongk");
        model.addAttribute("testVO", testVO);

        return "thymeleaf/thymeleafTest2";
    }

    @RequestMapping(value = "/thymeleafTest3", method = RequestMethod.GET)
    public String thymeleafTest3(Model model) {
        List<TestVO> list = new ArrayList<>();
        for (int i = 0; i < 5; i++)
            list.add(new TestVO("lilllung0" + i, "pilljoongk" + i));

        model.addAttribute("listVO", list);

        return "thymeleaf/thymeleafTest3";
    }

}
