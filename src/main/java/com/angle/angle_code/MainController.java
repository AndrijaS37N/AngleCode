package com.angle.angle_code;

import com.angle.angle_code.entities.AngleEntity;
import com.angle.angle_code.services.AngleEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

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
        model.addAttribute("angleEntitiesCount", angleEntityService.findAngleEntitiesCount());
        mainControllerLogger.info("Function showAngleEntityPage just before return");
        return "showAngleEntity";
    }

    @GetMapping("/viewAngleEntities")
    public String viewAngleEntitiesPage(Model model) {

        pageName = "Entities Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        model.addAttribute("angleEntities", angleEntityService.findAllAngleEntities());
        model.addAttribute("angleEntitiesCount", angleEntityService.findAngleEntitiesCount());
        mainControllerLogger.info("Function viewAngleEntitiesPage just before return");
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
    public String editAngleEntity(@PathVariable("id") long id, Model model) {

        AngleEntity angleEntity = angleEntityService.findAngleEntity(id);
        model.addAttribute("angleEntity", angleEntity);
        model.addAttribute("appName", appName);
        pageName = "Show Angle Entity Page";
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntitiesCount", angleEntityService.findAngleEntitiesCount());
        mainControllerLogger.info("Function editAngleEntity just before return");
        return "showAngleEntity";
    }

    @PostMapping("/update/{id}")
    public String updateAngleEntity(@PathVariable("id") long id, @Valid AngleEntity angleEntity, BindingResult result) {

        if (result.hasErrors()) {
            angleEntity.setAngleEntityId(id);
            return "showAngleEntity";
        }

        angleEntityService.updateAngleEntity(angleEntity, id);
        mainControllerLogger.info("Function updateAngleEntity just before return");
        return "redirect:/viewAngleEntities";
    }

    @PostMapping("/addAngleEntity")
    public String addAngleEntityPost(@ModelAttribute AngleEntity angleEntity, Model model) {

        pageName = "Show Angle Entity Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        angleEntityService.addAngleEntity(angleEntity);
        model.addAttribute("angleEntitiesCount", angleEntityService.findAngleEntitiesCount());

        mainControllerLogger.info("Function addAngleEntityPost name = " + angleEntity.getAngleEntityName());

        mainControllerLogger.info("Function addAngleEntityPost just before return");
        return "showAngleEntity";
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

    @PostMapping("/viewAngleEntities")
    public String searchAngleEntities(@ModelAttribute AngleEntity angleEntity, Model model) {

        model.addAttribute("angleEntities", angleEntityService.listAngleEntitiesByName(angleEntity.getAngleEntityName()));
        mainControllerLogger.info("Function searchAngleEntities angleEntityName = " + angleEntity.getAngleEntityName());
        mainControllerLogger.info("Function searchAngleEntities angleEntityService.listAngleEntitiesByName(angleEntity.getAngleEntityName()) = " + angleEntityService.listAngleEntitiesByName(angleEntity.getAngleEntityName()));
        mainControllerLogger.info("Function searchAngleEntities just before return");
        return "viewAngleEntities";
    }
}
