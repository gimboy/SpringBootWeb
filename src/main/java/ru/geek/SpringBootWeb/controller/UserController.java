package ru.geek.SpringBootWeb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geek.SpringBootWeb.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String goAllUsers(Model model) {
        model.addAttribute("users",userService.findAll());
        return "users";
    }

    @GetMapping("/{id}")
    public String goUser(Model model, @PathVariable long id) {
        model.addAttribute("user",userService.getUser(id).orElseThrow(NotFoundException::new));
        return "user";
    }

    @ExceptionHandler
    public String notFountExceptionHandler(NotFoundException ex) {
        return "notFound";
    }
}
