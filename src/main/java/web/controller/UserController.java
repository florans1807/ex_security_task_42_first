package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.UserServiceIn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserServiceIn userService;

    @Autowired
    public UserController(UserServiceIn userService) {
        this.userService = userService;
    }

    //1
    @GetMapping("/user")
    public String getUserInfo(Model model1, Authentication authentication) {
        model1.addAttribute("user", userService.loadUserByUsername(authentication.getName()));
        return "user_info";
    }

    //2
    @GetMapping("/admin")
    public String getAdminInfo(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin_info";
    }

    //3
    @GetMapping("/admin/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "show";
    }


    //5
    /*@PostMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user, @RequestParam("role") String[] roles
            , @RequestParam("id") int id, Model model) {
        user.setId(id);
        //user.setRoles(userService.getSetRole(roles));
        userService.update(user);
        model.addAttribute("user", user);
        return "redirect:/admin";
    }*/

    //6
    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    //7
    @GetMapping("/admin/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", userService.getAllRoles());
        return "new";
    }

    //4
    @GetMapping("/admin/{id}/edit")
    public String edit(Model model1, @PathVariable("id") int id) {
        model1.addAttribute("user", userService.get(id));
        model1.addAttribute("allRoles", userService.getAllRoles());
        return "edit";
    }

    //8
    @PostMapping(value="/admin/add")
    public String create(@ModelAttribute("user") User user
            , @RequestParam("role") String[] roles
            , @RequestParam(value = "active", required = false) boolean active) {

        user.setActive(active);
        user.setRoles(userService.getSetRole(roles));
        userService.add(user);
        return "redirect:/admin";
    }


    @PostMapping("/admin/{id}")
    public String update(@ModelAttribute("user") User user
            , @RequestParam("role") String[] roles
            , @RequestParam(value = "active", required = false) boolean active) {

        user.setActive(active);
        user.setRoles(userService.getSetRole(roles));
        userService.update(user);
        return "redirect:/admin";
    }

}