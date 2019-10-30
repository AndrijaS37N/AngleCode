package com.angle.angle_code;

import com.angle.angle_code.entities.AngleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/public")
@CrossOrigin
public class MainController {

    private final static Logger mainControllerLogger = LoggerFactory.getLogger(MainController.class);

    @Value("${spring.application.name}")
    public String appName;
    @Value("${page.name.homePage}")
    private String homePageName;

    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", homePageName);
        model.addAttribute("angleEntity", new AngleEntity());
        mainControllerLogger.info("Function homePage just before return");
        return "home";
    }

    @GetMapping("/termsAndConditions")
    public String termsAndConditionsPage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", homePageName);
        model.addAttribute("angleEntity", new AngleEntity());
        mainControllerLogger.info("Function termsAndConditionsPage just before return");
        return "termsAndConditions";
    }
}
