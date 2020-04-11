package com.launchcode.myLibrary.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="wishlist")
public class WishlistController {

    @RequestMapping(value="", method = RequestMethod.GET)
    public String displaywish (Model model){
        model.addAttribute("title", "wishList");
        return "wishlist/wishlist";
    }

}
