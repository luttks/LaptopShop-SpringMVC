package vn.luthanh.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.luthanh.laptopshop.domain.User;
import vn.luthanh.laptopshop.repository.UserRepository;
import vn.luthanh.laptopshop.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        model.addAttribute("test", "test");
        model.addAttribute("test2", "From User Controller");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping(value = "/admin/user/create1", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User newUser) {
        System.out.println("Create User " + newUser);
        this.userService.handleSaveUser(newUser);
        return "hello";
    }
}

// method get : data gui len url, bao mat khong cao //
// method post : khong gioi han dung luong data
// <form method="post" action="/admin/user/create"> tra ve url

//