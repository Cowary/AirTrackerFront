package org.cowary.arttrackerfront.controller.list;

import org.cowary.arttrackerfront.entity.User;
import org.cowary.arttrackerfront.service.GameService;
import org.cowary.arttrackerfront.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PlayListController {

    @Autowired
    GameService gameService;

    @GetMapping("/title/view/play")
    public String get(@RequestParam(required = false, defaultValue = "") String status,
                      Model model) {
        var mediaList = gameService.getAll(SystemUtil.getUserid(), status);
        model.addAttribute("mediaList", mediaList);
        return "media/view/play";
    }
}
