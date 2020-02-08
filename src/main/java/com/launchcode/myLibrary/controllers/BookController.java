package com.launchcode.myLibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
    @RequestMapping(value ="book")
    @ResponseBody
    public String displaygenres(){
        return "book";
    }
}
