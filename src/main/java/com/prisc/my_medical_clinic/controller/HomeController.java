package com.prisc.my_medical_clinic.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/home")
public class HomeController {

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String hello(){
        return "hello world";
    }

    @ResponseBody
    @RequestMapping(value = "/doctor",method = RequestMethod.GET)
    public String doc(){
        return "hello doc";
    }

    @ResponseBody
    @RequestMapping(value = "/patient",method = RequestMethod.GET)
    public String patiente(){
        return "hello patient";
    }

    @ResponseBody
    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String admin(){
        return "hello admin";
    }
}



