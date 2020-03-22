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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
@RequestMapping(value="home")
public class BookController {
    @Autowired
    private BookDao bookDao;

    //Add book to the library
    @RequestMapping(value="addbook", method=RequestMethod.GET)
    public String displayaddbook(Model model){
        model.addAttribute("title","Add books");
        model.addAttribute("book", new Book());
        return "home/addbook";
    }

    @RequestMapping(value="addbook", method=RequestMethod.POST)
    public String addbook(@Valid Book newBook, Errors errors, Model model, RedirectAttributes redirectAttributes, Book book){
        if (errors.hasErrors()){
            model.addAttribute("title","All books");
            return "home/addbook";
        }
        redirectAttributes.addFlashAttribute("message", "Successfully Added");
        bookDao.save(newBook);
        redirectAttributes.addFlashAttribute("book", book);
        return "redirect:bookconfirmation";
    }

    //View of Confirmation page (Flashmessage)
    @RequestMapping(value="bookconfirmation", method=RequestMethod.GET)
    public String bookconfirmation(Model model){
        model.addAttribute("title", "Confirmation Page");
        return "home/bookconfirmation";
    }

    //View books in the library
    @RequestMapping(value="index", method=RequestMethod.GET)
    public String displaybook(Model model){
        model.addAttribute("title","All books");
        model.addAttribute("book",bookDao.findAll());
        return "home/index";
    }

}
