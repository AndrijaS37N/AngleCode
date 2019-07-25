package com.angle.angle_code;

import com.angle.angle_code.entities.AngleEntity;
import com.angle.angle_code.services.AngleEntityService;
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

    @Autowired
    AngleEntityService angleEntityService;

    @GetMapping("/")
    public String homePage(Model model) {

        pageName = "Home";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        mainControllerLogger.info("Function homePage just before return");
        return "home";
    }

    @PostMapping("/")
    public String homePagePost(@ModelAttribute AngleEntity angleEntity, Model model) {

        pageName = "Show AngleEntity";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        angleEntityService.addAngleEntity(angleEntity);
        mainControllerLogger.info("Function homePagePost just before return");
        return "showAngleEntity";
    }

    @GetMapping("/showAngleEntity")
    public String showAngleEntityPage(Model model) {

        pageName = "Show AngleEntity";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        angleEntityService.printAllAngleEntities();
        mainControllerLogger.info("Function showAngleEntityPage just before return");
        return "showAngleEntity";
    }
}
