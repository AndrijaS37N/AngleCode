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
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/access")
@CrossOrigin
public class LogInController {

    private final static Logger logInControllerLogger = LoggerFactory.getLogger(MainController.class);

    @Value("${spring.application.name}")
    public String appName;
    @Value("${page.name.logInPage}")
    private String logInPageName;

    private List<String> errorList = new ArrayList<>();

    @Autowired
    private UserService userService;

    @Value("${logIn.message.success}")
    private String logInSuccessfulMessage;
    @Value("${logIn.message.error}")
    private String logInErrorMessage;
    @Value("${logIn.message.error.credentialsError}")
    private String credentialsErrorMessage;
    @Value("${logIn.message.error.emailNotRegistered}")
    private String emailNotRegisteredMessage;

    @GetMapping("/logIn")
    public String logInPage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", logInPageName);
        model.addAttribute("angleEntity", new AngleEntity());
        model.addAttribute("errorMessages", errorList);
        model.addAttribute("user", new User());
        logInControllerLogger.info("Function logInPage just before return");
        return "logIn";
    }

    @PostMapping("/logIn")
    public String logInPagePost(@Valid @ModelAttribute("user") User user, Model model) {

        // TODO -> Make logging in more secure. | Not null and not empty errors -> Fix that.
        model.addAttribute("errorMessages", errorList);

        if (userService.authenticate(user)) {
            model.addAttribute("logInSuccessfulMessage", logInSuccessfulMessage);
            return "home";
        } else if (!userService.checkIfUserExists(user)) {
            errorList.add(emailNotRegisteredMessage);
            model.addAttribute("errorMessages", errorList);
        } else {
            errorList.add(logInErrorMessage);
            errorList.add(credentialsErrorMessage);
            model.addAttribute("errorMessages", errorList);
        }

        return "logIn";
    }
}
