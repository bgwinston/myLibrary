package com.launchcode.myLibrary.controllers;


import com.launchcode.myLibrary.models.Data.bookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "checkout")
public class CheckoutController {

    @Autowired
    private bookDao bookDao;

    //Checkout books
    @RequestMapping(value = "", method = RequestMethod.GET)

    public String displaycheckout(Model model) {
        model.addAttribute("title", "Check out Book");
        model.addAttribute("book", bookDao.findAll());
        return "home/checkout";
    }

    @RequestMapping(value = "allbooks", method = RequestMethod.GET)
    public String displayall(Model model) {
        model.addAttribute("title", "All Books");
        model.addAttribute("book", bookDao.findAll());
        return "checkout/allbooks";
    }

    /*@RequestMapping(value="allbooks", method=RequestMethod.GET)
    public String all(Model model) {


    }*/
    @RequestMapping(value = "selection", method = RequestMethod.POST)
    public String Selection(int[] bookids, RedirectAttributes redirectAttributes) {
        if (bookids != null) {
            for (int id : bookids) {
                redirectAttributes.addFlashAttribute("message", "You have successfully checked out");
                redirectAttributes.addFlashAttribute("book", bookDao.findById(id));
                return "redirect:checkout/selection";
            }

        }
        return "checkout/selection";
    }

    @RequestMapping(value = "selection", method = RequestMethod.GET)
    public String displaySelection(Model model) {
        model.addAttribute("title", "Check out");
        return "checkout/selection";
    }
}