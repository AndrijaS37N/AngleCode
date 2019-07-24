package com.angle.angle_code;

import com.angle.angle_code.entities.AngleEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private final static Logger mainControllerLogger = LoggerFactory.getLogger(MainController.class);

    @Value("${spring.application.name}")
    public String appName;

    private String pageName;

    private AngleEntity angleEntity = new AngleEntity("");

    @GetMapping("/")
    public String homePage(Model model) {

        pageName = "Home";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        mainControllerLogger.info("MAIN CONTROLLER LOG POINT: homePage just before the return");
        return "home";
    }

    @PostMapping("/")
    public String homePagePost(@ModelAttribute AngleEntity angleEntity, Model model) {

        pageName = "Show AngleEntity";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        mainControllerLogger.info("MAIN CONTROLLER LOG POINT: homePagePost just before the return");
        return "showAngleEntity";
    }

    @GetMapping("/showAngleEntity")
    public String showEntityPage(Model model) {

        pageName = "Show AngleEntity";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        mainControllerLogger.info("MAIN CONTROLLER LOG POINT: showAngleEntityPage just before the return");
        return "showAngleEntity";
    }
}
