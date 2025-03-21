package vn.luthanh.laptopshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.luthanh.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
    this.userService = userService;
    }

    @RequestMapping("/index")
    public String getHomePage() {
        String  test = this.userService.handleHello();
        return "index.html";
    }
}

// // dependency injection
// private UserService userService;

// public UserController(UserService userService) {
// this.userService = userService;
// }

// @GetMapping("")
// public String getHomePage() {
// return this.userService.handleHello();
// }

// @Controller ==> MVC
// public class UserController {

// @RequestMapping("/")
// public String getHomePage() {
// return "hello from user controller";
// }
// }