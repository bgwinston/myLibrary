package com.launchcode.myLibrary.controllers;

import com.launchcode.myLibrary.models.Data.wishlistDao;
import com.launchcode.myLibrary.models.Wish;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}
