package com.gmail.lilllung09.airlinereservation.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
class ErrorPageController implements ErrorController {

    @RequestMapping(value = "/error")
    public ModelAndView handleError(HttpServletRequest request) {
        Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Object path = request.getAttribute(RequestDispatcher.ERROR_REQUEST_URI);

        String error_message = message != null ? String.valueOf(message) : "null";
        int error_code = status != null ? Integer.parseInt(status.toString()) : 0;
        String error_path = path != null ? String.valueOf(path) : "null";

        ModelAndView mav = new ModelAndView("thymeleaf/error/errorPage");
        mav.addObject("error_type", error_message);
        mav.addObject("error_code", error_code);
        mav.addObject("error_path", error_path);

        return mav;
    }
}
