package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserServiceIn;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceIn userService;

    @Autowired
    public AdminController(UserServiceIn userService) {
        this.userService = userService;
    }

    //2
    @GetMapping
    public String getAdminInfo(Model model) {
        model.addAttribute("users", userService.getAll());
        return "admin_info";
    }

    //3
    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.get(id));
        return "show";
    }

    //6
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/admin";
    }

    //7
    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", userService.getAllRoles());
        return "new";
    }

    //4
    @GetMapping("/{id}/edit")
    public String edit(Model model1, @PathVariable("id") int id) {
        model1.addAttribute("user", userService.get(id));
        model1.addAttribute("allRoles", userService.getAllRoles());
        return "edit";
    }

    //8
    @PostMapping(value="/add")
    public String create(@ModelAttribute("user") User user
            , @RequestParam("role") String[] roles) {

        user.setRoles(userService.getSetRole(roles));
        userService.add(user);
        return "redirect:/admin";
    }


    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user
            , @RequestParam("role") String[] roles) {

        user.setRoles(userService.getSetRole(roles));
        userService.update(user);
        return "redirect:/admin";
    }
}
