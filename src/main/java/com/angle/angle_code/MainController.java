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

import java.util.List;

@Controller
public class MainController {

    private final static Logger mainControllerLogger = LoggerFactory.getLogger(MainController.class);

    @Value("${spring.application.name}")
    public String appName;
    public String pageName;

    private AngleEntity angleEntity = new AngleEntity("");

    @Autowired
    AngleEntityService angleEntityService;

    @GetMapping("/")
    public String homePage(Model model) {

        pageName = "Home Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        mainControllerLogger.info("Function homePage just before return");
        return "home";
    }

    // Note: Not really using this post method.
    @PostMapping("/")
    public String homePagePost(@ModelAttribute AngleEntity angleEntity, Model model) {

        pageName = "Show Angle Entity Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        angleEntityService.addAngleEntity(angleEntity);
        mainControllerLogger.info("Function homePagePost just before return");
        return "showAngleEntity";
    }

    @GetMapping("/showAngleEntity")
    public String showAngleEntityPage(Model model) {

        pageName = "Show Angle Entity Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        mainControllerLogger.info("Function showAngleEntityPage just before return");
        return "showAngleEntity";
    }

    @GetMapping("/viewAngleEntities")
    public String viewAngleEntitiesPage(Model model) {

        pageName = "Entities Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        List<AngleEntity> angleEntities = angleEntityService.findAllAngleEntities();
        model.addAttribute("angleEntities", angleEntities);
        mainControllerLogger.info("Function angleEntitiesPage just before return");
        return "viewAngleEntities";
    }

    @GetMapping("/delete/{id}")
    public String deleteAngleEntity(@PathVariable("id") long id) {
        angleEntityService.deleteAngleEntity(id);
        mainControllerLogger.info("Function deleteAngleEntity just before return");
        return "redirect:/viewAngleEntities";
    }

    @GetMapping("/addAngleEntity")
    public String addAngleEntityPage(Model model) {

        pageName = "Add Angle Entity Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        mainControllerLogger.info("Function addAngleEntityPage just before return");
        return "addAngleEntity";
    }

    @GetMapping("/edit/{id}")
    public String editAngleEntity(@PathVariable("id") long id) {

        // angleEntityService.editAngleEntity(id);
        mainControllerLogger.info("Function editAngleEntity just before return");
        return "redirect:/showAngleEntity";
    }
}
