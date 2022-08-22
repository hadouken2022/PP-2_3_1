package web_hibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web_hibernate.model.User;
import web_hibernate.service.UserService;

import java.util.List;

@Controller
public class UsersController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String showAllUsers(Model model) {
        List<User> userList = userService.listUsers();
        model.addAttribute("allUsers", userList);
        return "users";
    }

    @RequestMapping("addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-details";
    }

    @RequestMapping("createUser")
    public String createUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("editUser")
    public String editUser(@RequestParam("userID") int id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-details";
    }

    @RequestMapping("deleteUser")
    public String deleteUser(@RequestParam("userID") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
