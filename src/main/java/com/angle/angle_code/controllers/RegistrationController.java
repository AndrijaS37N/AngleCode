package com.angle.angle_code.controllers;

import com.angle.angle_code.MainController;
import com.angle.angle_code.entities.AngleEntity;
import com.angle.angle_code.entities.User;
import com.angle.angle_code.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class RegistrationController {

    private final static Logger registrationControllerLogger = LoggerFactory.getLogger(MainController.class);

    @Value("${spring.application.name}")
    public String appName;
    @Value("${page.name.homePage}")
    private String homePageName;
    @Value("${page.name.registerPage}")
    private String registerPageName;

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model) {

        model.addAttribute("appName", appName);
        model.addAttribute("pageName", registerPageName);
        model.addAttribute("angleEntity", new AngleEntity());
        registrationControllerLogger.info("Function registerPage just before return");
        return "register";
    }

    @PostMapping("/register")
    public String registerPagePost(@ModelAttribute @Valid User user, Model model) {

        model.addAttribute("appName", appName);
        model.addAttribute("pageName", homePageName);
        model.addAttribute("user", new User());

        // TODO -> Registration.

        List<String> errorList = new ArrayList<>();

        if(userService.checkIfUserExists(user)) {
            errorList.add("registration.message.error");
            errorList.add("registration.error.checkIfUserExists");
            model.addAttribute("errorMessages", errorList);
            return "register";
        } else {
            userService.addUser(user);
            model.addAttribute("successMessage", "registration.message.successfulRegistration");
            return "logIn";
        }
    }
}
