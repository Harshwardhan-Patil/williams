package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserDao userDao;

    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public String listUsers(Model model) {
        List<User> users = userDao.findAll();
        model.addAttribute("users", users);
        return "userList";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "userForm";
    }

    @PostMapping
    public String saveUser(@ModelAttribute User user) {
        userDao.save(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable int id, Model model) {
        User user = userDao.findById(id);
        model.addAttribute("user", user);
        return "userForm";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable int id, @ModelAttribute User user) {
        user.setId(id);
        userDao.update(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable int id) {
        userDao.delete(id);
        return "redirect:/users";
    }
}
