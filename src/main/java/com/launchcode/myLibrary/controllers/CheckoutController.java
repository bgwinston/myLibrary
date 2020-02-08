package com.launchcode.myLibrary.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CheckoutController {
    @RequestMapping(value = "checkout")
    @ResponseBody
    public String displaycheckout(){
        return "checkout";
    }
}
