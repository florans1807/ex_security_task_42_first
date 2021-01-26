package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


@Controller
//@RequestMapping("/")
public class UserController {

    @GetMapping("/")
    public String getInfoForAllEmp() {
        return "viewForAllEmp";
    }

    @GetMapping("/hr_info")
    public String getInfoForHR() {
        return "viewForHR";
    }

    @GetMapping("/manager_info")
    public String getInfoForManagers() {
        return "viewForManager";
    }

    /*@RequestMapping(value = "hello", method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }
*/
}

