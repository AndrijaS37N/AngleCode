package com.angle.angle_code.controllers;

import com.angle.angle_code.entities.AngleEntity;
import com.angle.angle_code.services.AngleEntityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.validation.Valid;

@SuppressWarnings("SpellCheckingInspection")
@Controller
public class AngleEntityController {

    private final static Logger angleEntityControllerLogger = LoggerFactory.getLogger(AngleEntityController.class);

    @Value("${spring.application.name}")
    public String appName;
    private String pageName;
    private AngleEntity angleEntity = new AngleEntity("");

    @Autowired
    private AngleEntityService angleEntityService;

    @GetMapping("/showAngleEntity")
    public String showAngleEntityPage(Model model) {

        pageName = "Show Angle Entity Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        model.addAttribute("angleEntitiesCount", angleEntityService.findAngleEntitiesCount());
        angleEntityControllerLogger.info("Function showAngleEntityPage just before return");
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
        angleEntityControllerLogger.info("Function viewAngleEntitiesPage just before return");
        return "viewAngleEntities";
    }

    @GetMapping("/delete/{id}")
    public String deleteAngleEntity(@PathVariable("id") long id) {
        angleEntityService.deleteAngleEntity(id);
        angleEntityControllerLogger.info("Function deleteAngleEntity just before return");
        return "redirect:/viewAngleEntities";
    }

    @GetMapping("/addAngleEntity")
    public String addAngleEntityPage(Model model) {

        pageName = "Add Angle Entity Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntity", angleEntity);
        angleEntityControllerLogger.info("Function addAngleEntityPage just before return");
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
        angleEntityControllerLogger.info("Function editAngleEntity just before return");
        return "showAngleEntity";
    }

    @PostMapping("/update/{id}")
    public String updateAngleEntity(@PathVariable("id") long id, @Valid AngleEntity angleEntity, BindingResult result) {

        if (result.hasErrors()) {
            angleEntity.setAngleEntityId(id);
            return "showAngleEntity";
        }

        angleEntityService.updateAngleEntity(angleEntity, id);
        angleEntityControllerLogger.info("Function updateAngleEntity just before return");
        return "redirect:/viewAngleEntities";
    }

    @PostMapping("/addAngleEntity")
    public String addAngleEntityPost(@ModelAttribute AngleEntity angleEntity, Model model) {

        pageName = "Show Angle Entity Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        angleEntityService.addAngleEntity(angleEntity);
        model.addAttribute("angleEntitiesCount", angleEntityService.findAngleEntitiesCount());
        angleEntityControllerLogger.info("Function addAngleEntityPost name = " + angleEntity.getAngleEntityName());
        angleEntityControllerLogger.info("Function addAngleEntityPost just before return");
        return "showAngleEntity";
    }

    @PostMapping("/viewAngleEntities")
    public String searchAngleEntities(@ModelAttribute AngleEntity angleEntity, Model model) {

        pageName = "Entities Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntities", angleEntityService.listAngleEntitiesByName(angleEntity.getAngleEntityName()));
        angleEntityControllerLogger.info("Function searchAngleEntities angleEntityName = " + angleEntity.getAngleEntityName());
        angleEntityControllerLogger.info("Function searchAngleEntities angleEntityService.listAngleEntitiesByName(angleEntity.getAngleEntityName()) = " + angleEntityService.listAngleEntitiesByName(angleEntity.getAngleEntityName()));
        angleEntityControllerLogger.info("Function searchAngleEntities just before return");
        return "viewAngleEntities";
    }

    @PostMapping("/navbarSearchAngleEntity")
    public String searchAngleEntitiesFromNavbar(@ModelAttribute AngleEntity angleEntity, Model model) {

        pageName = "Entities Page";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("angleEntities", angleEntityService.listAngleEntitiesByName(angleEntity.getAngleEntityName()));
        angleEntityControllerLogger.info("Function searchAngleEntitiesFromNavbar just before return");
        return "viewAngleEntities";
    }

    @GetMapping("/navbar")
    public String passObjectToNavbar(@ModelAttribute AngleEntity angleEntity, Model model) {

        model.addAttribute("angleEntity", angleEntity);
        angleEntityControllerLogger.info("Function passObjectToNavbar just before return");
        return "navbar";
    }
}
