package be.scrumdilicious.blogOpdracht.controllers;
/*
import be.scrumdilicious.blogOpdracht.security.UserDetailsClass;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

 */
import be.scrumdilicious.blogOpdracht.data.ERole;
import be.scrumdilicious.blogOpdracht.data.Post;
import be.scrumdilicious.blogOpdracht.data.User;
import be.scrumdilicious.blogOpdracht.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Controller
public class UserControllers {

    private UserService userService;

    @Autowired
    public UserControllers(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/test")
    public String showAll(){


        return "test";
    }



    /*
    @GetMapping("/showUserInfo")
    public String showUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsClass userDetails = (UserDetailsClass) authentication.getPrincipal();
        System.out.println(userDetails.getUser());

        return "test";
    }

     */

    /*
    @GetMapping("/{username}")
    public String getUser(@PathVariable("username") String username, Model model) {
        User user = userService.getCurrentUser(username);
        model.addAttribute("user", user );
        return "test";

    }

     */


    @GetMapping("/users")
    public String showAll(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

/*
    @PostMapping("/users/{name}")
    public String seeAllUserssByName(Model model, @PathVariable String name) {
        User user = userService.getCurrentUser(name);
        model.addAttribute("user", user);
        model.addAttribute("name", name);


        return "users";
    }

 */


    @PostMapping("/addUser")
    public String addUser(String name, String username, String lastname, String email,
                          String password, String street, int houseN, String city, Long zip) {
        User user = new User(name, username, lastname, email, password, street, houseN, city, zip);
        userService.createUser(user);
        return "redirect:/test";
    }












}
