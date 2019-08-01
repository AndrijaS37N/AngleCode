package com.angle.angle_code.controllers;

import com.angle.angle_code.MainController;
import com.angle.angle_code.entities.AngleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogInController {

    private final static Logger logInControllerLogger = LoggerFactory.getLogger(MainController.class);

    @Value("${spring.application.name}")
    public String appName;
    @Value("${page.name.logInPage}")
    private String logInPageName;

    @GetMapping("/logIn")
    public String logInPage(Model model) {

        model.addAttribute("appName", appName);
        model.addAttribute("pageName", logInPageName);
        model.addAttribute("angleEntity", new AngleEntity());
        logInControllerLogger.info("Function logInPage just before return");
        return "logIn";
    }
}
