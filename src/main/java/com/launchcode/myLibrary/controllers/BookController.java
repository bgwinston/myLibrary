package com.launchcode.myLibrary.controllers;

import com.launchcode.myLibrary.models.Book;
import com.launchcode.myLibrary.models.Data.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;


@Controller
@RequestMapping(value="home")
public class BookController {
    @Autowired
    private BookDao bookDao;

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
    public String displayaddbook(Model model){
        model.addAttribute("title","Add books");
        return "home/addbook";
    }

    @RequestMapping(value="addbook", method=RequestMethod.POST)
    public String addbook(@Valid Book newBook, Errors errors, Model model){
        if (errors.hasErrors()){
            model.addAttribute("title","All books");
            return "home/addbook";
        }
        return "home/addconfirmation";
    }
    //View books in the library
    @RequestMapping(value="index", method=RequestMethod.GET)
    public String displaybook(Model model){
        model.addAttribute("title","All books");
        model.addAttribute("book",bookDao.findAll());
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
