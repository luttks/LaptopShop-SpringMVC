package vn.luthanh.laptopshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.luthanh.laptopshop.domain.User;
import vn.luthanh.laptopshop.repository.UserRepository;
import vn.luthanh.laptopshop.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        String test = this.userService.handleHello();
        List<User> arrUser = this.userService.getAllUserByEmail("2@gmail.com");
        System.out.println(arrUser);
        model.addAttribute("test", "test");
        model.addAttribute("test2", "From User Controller");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getUserPage(Model model) {
        List<User> users = this.userService.getAllUsers();
        System.out.println("Check users: " + users);
        model.addAttribute("users1", users);
        return "admin/user/table-user";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable Long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("id", +id);
        model.addAttribute("user", user);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable Long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping("/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User oldUser) {
        User currentUser = this.userService.getUserById(oldUser.getId());
        if (currentUser != null) {
            currentUser.setFullName(oldUser.getFullName());
            currentUser.setAddress(oldUser.getAddress());
            currentUser.setPhone(oldUser.getPhone());
            this.userService.handleSaveUser(currentUser);
        }

        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User newUser) {

        this.userService.handleSaveUser(newUser);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable Long id) {
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping("/admin/user/delete/{id}")
    public String postDeleteUserPage(Model model, @ModelAttribute("newUser") User newUser) {
        this.userService.deleteUserById(newUser.getId());
        return "redirect:/admin/user";
    }
}

// method get : data gui len url, bao mat khong cao //
// method post : khong gioi han dung luong data
// <form method="post" action="/admin/user/create"> tra ve url

//

