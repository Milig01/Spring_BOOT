package org.example.spring_boot_test.controller;

import lombok.RequiredArgsConstructor;
import org.example.spring_boot_test.model.User;
import org.example.spring_boot_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserController {
    @Autowired
    private final UserService userService;

    @GetMapping("/")
    public String getAll(ModelMap model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "getAll";
    }

    @GetMapping("pageAdd")
    public String pageAdd() {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") long id) {
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(@RequestParam("id") long id, ModelMap model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping("updateUser")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }
}
