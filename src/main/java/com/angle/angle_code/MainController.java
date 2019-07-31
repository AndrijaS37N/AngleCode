package com.angle.angle_code;

import com.angle.angle_code.entities.AngleEntity;
import com.angle.angle_code.entities.User;
// import com.angle.angle_code.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {

    private final static Logger mainControllerLogger = LoggerFactory.getLogger(MainController.class);

    @Value("${spring.application.name}")
    public String appName;
    private String pageName;
    private AngleEntity angleEntity = new AngleEntity("");

//    @Autowired
//    private UserService userService;

    @GetMapping("/")
    public String homePage(Model model) {

        pageName = "Home Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        mainControllerLogger.info("Function homePage just before return");
        return "home";
    }

    @GetMapping("/logIn")
    public String logInPage(Model model) {

        pageName = "Log In Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        mainControllerLogger.info("Function logInPage just before return");
        return "logIn";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {

        pageName = "Sign Up Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        mainControllerLogger.info("Function registerPage just before return");
        return "register";
    }

    @PostMapping("/register")
    public String registerPagePost(@ModelAttribute User user, Model model) {

        pageName = "Home Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);

        // TODO -> Registration.

        // userService.addUser(user);


        return "home";
    }
}
