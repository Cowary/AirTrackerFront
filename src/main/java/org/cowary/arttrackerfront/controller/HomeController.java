package org.cowary.arttrackerfront.controller;

import org.cowary.arttrackerfront.config.ConfigApp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/title")
    public String getHome(Model model) {
        return "home";
    }
}
