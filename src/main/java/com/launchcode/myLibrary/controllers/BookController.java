package com.launchcode.myLibrary.controllers;

import com.launchcode.myLibrary.models.Book;
import com.launchcode.myLibrary.models.Data.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
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

    //Delete a Book
    @GetMapping("delete")
    public String displaydelete(Model model) {
        model.addAttribute("title", "Delete book");
        model.addAttribute("books", bookDao.findAll());
        return "home/delete";
    }

    //User selects which student to delete
    //Selected student found in database
    //Student removed from database
    @PostMapping("delete")
    public String processdeletestudentform(@RequestParam(required = false) int[] bookids,RedirectAttributes redirectAttributes, Book book) {
        if (bookids != null) {
            for (int id : bookids) {
                bookDao.deleteById(id);
                redirectAttributes.addFlashAttribute("book", book);
            }
            redirectAttributes.addFlashAttribute("message", "Successfully deleted");
            return "redirect:deleteconfirmation";
        }
        return "home/delete";


    }

    //View of delete Confirmation page (Flashmessage)
    @RequestMapping(value="deleteconfirmation", method=RequestMethod.GET)
    public String deleteconfirmation(Model model, Book book,RedirectAttributes redirectAttributes){
        model.addAttribute("title", "Bye Bye Book");
        return "home/deleteconfirmation";
    }
}
