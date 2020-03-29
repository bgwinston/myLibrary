package com.launchcode.myLibrary.controllers;


import com.launchcode.myLibrary.models.Data.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Book;

@Controller
@RequestMapping(value = "checkout")
public class CheckoutController {
    @Autowired
    private BookDao bookDao;
    //Checkout b
    @RequestMapping(value = "", method= RequestMethod.GET)
    public String displaycheckout(Model model){
        model.addAttribute("title","Check out Book");
        model.addAttribute("book", bookDao.findAll());
        return "home/checkout";
    }

    @RequestMapping(value="results", method=RequestMethod.GET)
    public String displayResults(Model model){
        model.addAttribute("title", "Search Results");
        model.addAttribute("book", bookDao.findAll());
        return "checkout/results";
    }
}
