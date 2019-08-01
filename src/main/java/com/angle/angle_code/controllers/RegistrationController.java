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
import java.util.concurrent.TimeUnit;

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

    @Value("${registration.message.successfulRegistration}")
    private String successfulRegistrationMessage;

    private List<String> errorList = new ArrayList<>();
    @Value("${registration.message.error}")
    private String basicRegistrationError;
    @Value("${registration.error.checkIfUserExists}")
    private String checkIfUserExistsMessage;
    @Value("${registration.error.checkIfPasswordsMatch}")
    private String checkIfPasswordsMatchMessage;

    @GetMapping("/register")
    public String registerPage(Model model) {

        errorList.clear();
        model.addAttribute("errorMessages", errorList);

        model.addAttribute("appName", appName);
        model.addAttribute("pageName", registerPageName);
        model.addAttribute("user", new User());
        model.addAttribute("angleEntity", new AngleEntity());
        model.addAttribute("errorMessages", errorList);

        registrationControllerLogger.info("Function registerPage just before return");
        return "register";
    }

    @PostMapping("/register")
    public String registerPagePost(@Valid @ModelAttribute("user") User user, Model model) {

        model.addAttribute("appName", appName);
        model.addAttribute("pageName", registerPageName);
        model.addAttribute("angleEntity", new AngleEntity());

        errorList.clear();
        model.addAttribute("errorMessages", errorList);

        // TODO -> Registration completed. Now make it more secure.

        if (userService.checkIfUserExists(user)) {
            errorList.add(basicRegistrationError);
            errorList.add(checkIfUserExistsMessage);
        } else if (userService.checkIfPasswordsMatch(user.getUserPassword(), user.getConfirmedPassword())) {
            errorList.add(checkIfPasswordsMatchMessage);
        } else {
            userService.addUser(user);
            model.addAttribute("successMessage", successfulRegistrationMessage);

//            try {
//                TimeUnit.SECONDS.sleep(3);
//            } catch (InterruptedException error) {
//                registrationControllerLogger.error(error.toString());
//            }

            model.addAttribute("user", new User());
        }

        return "register";
    }
}