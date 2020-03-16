package com.launchcode.myLibrary.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="home")
public class BookController {
    //show genre categories. Links of genres that will take you to books in genre.
    @RequestMapping(value ="genre", method= RequestMethod.GET)
    public String displaygenres(){
        return "home/genre";
    }

    @RequestMapping(value="genre", method= RequestMethod.POST)
    public String genres(){
        return "home/genre";
    }

    //Add book to the library
    @RequestMapping(value="addbook", method=RequestMethod.GET)
    public String displayaddbook(){
        return "home/addbook";
    }
    @RequestMapping(value="addbook", method=RequestMethod.POST)
    public String addbook(){
        return "home/addbook";
    }

    //View books in the library
    @RequestMapping(value="index", method=RequestMethod.GET)
    public String displaybook(){
        return "home/index";
    }
    @RequestMapping(value="index", method=RequestMethod.POST)
    public String processbook() {
        return "home/index";
    }
    //Display authors.  Links of authors names, lead to their books
    @RequestMapping(value="author", method=RequestMethod.GET)
    public String displayauthor(){
        return "home/author";
    }
    @RequestMapping(value="author", method=RequestMethod.POST)
    public String processauthor(){
        return "home/author";
    }
}
