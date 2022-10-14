package be.scrumdilicious.blogOpdracht.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserControllers {

    @GetMapping("/")
    public String showAll(){


        return "test";
    }
}
