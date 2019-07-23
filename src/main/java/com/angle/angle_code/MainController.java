package com.angle.angle_code;

import com.angle.angle_code.entities.Entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Value("${spring.application.name}")
    public String appName;

    private String pageName;

    private Entity entity = new Entity();

    @GetMapping("/")
    public String homePage(Model model) {

        pageName = "Home";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("entity", entity);
        return "home";
    }

    @PostMapping("/")
    public String homePagePost(@ModelAttribute Entity entity) {
        return "showEntity";
    }

    @GetMapping("/showEntity")
    public String showEntityPage(Model model) {

        pageName = "Show Entity";
        model.addAttribute("appName", appName);
        model.addAttribute("pageName", pageName);
        model.addAttribute("entity", entity);
        return "showEntity";
    }
}
