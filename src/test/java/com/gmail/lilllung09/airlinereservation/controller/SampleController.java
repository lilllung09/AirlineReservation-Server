package com.gmail.lilllung09.airlinereservation.controller;

import com.gmail.lilllung09.airlinereservation.dto.TestDTO;
import com.gmail.lilllung09.airlinereservation.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class SampleController {

    //url 경로를 변수화하여 사용
    @RequestMapping(value = "/member/{name}/{age}")
    @ResponseBody
    public Object member(
            @PathVariable(value = "name") String name,
            @PathVariable(value = "age") String age) {

        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);

        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public Object loginGET(
            @RequestParam(value ="id", required = false, defaultValue = "defaultID") String id,
            @RequestParam(value ="name", required = false, defaultValue = "defaultNAME") String name) {

        Map<String, String> map = new HashMap<>();
        map.put("Method", "GET");

        map.put("id", id);
        map.put("name", name);

        return map;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Object loginPOST(
            //@RequestParam(value ="id", required = false, defaultValue = "defaultID") String id,
            //@RequestParam(value ="name", required = false, defaultValue = "defaultNAME") String name,
            @RequestBody TestDTO testDTO) {

        Map<String, String> map = new HashMap<>();
        map.put("Method", "POST");

        map.put("id", testDTO.getId());
        map.put("name", testDTO.getName());

        return map;
    }


    @Autowired
    TestService testService;

    @RequestMapping(value = "/info")
    public ModelAndView showInfo() {
        ModelAndView mav = new ModelAndView("thymeleaf/info");

        List<TestDTO> listDTO = testService.selectTest();
        mav.addObject("listDTO", listDTO);

        return mav;
    }
}
