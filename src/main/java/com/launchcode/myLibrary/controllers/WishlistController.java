package com.launchcode.myLibrary.controllers;

import com.launchcode.myLibrary.models.Data.wishlistDao;
import com.launchcode.myLibrary.models.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping(value="wishlist")
public class WishlistController {

    @Autowired
    private wishlistDao wishlistDao;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String displaywish (Model model){
        model.addAttribute("title", "wishList");
        model.addAttribute("wish", new Wish());
        return "wishlist/wishlist";
    }
    @RequestMapping(value="", method = RequestMethod.POST)
    public String wish(@Valid Wish newWish, Model model, Errors errors, RedirectAttributes redirectAttributes, Wish wish) {
        if (errors.hasErrors()) {
            return "wishlist/wishlist";
        }
        redirectAttributes.addFlashAttribute("message", "You've successfully added");
        wishlistDao.save(newWish);
        model.addAttribute("wish", new Wish());
        redirectAttributes.addFlashAttribute("wish", wish);
        return "redirect:wishlist/wishConfirmation";
    }
    //View of Confirmation page (Flashmessage)
    @RequestMapping(value="wishConfirmation", method=RequestMethod.GET)
    public String wishconfirmation(Model model){
        model.addAttribute("title", "Confirmation Page");
        return "wishlist/wishConfirmation";
    }
}
