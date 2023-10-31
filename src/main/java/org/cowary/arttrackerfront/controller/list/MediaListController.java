package org.cowary.arttrackerfront.controller.list;

import org.cowary.arttrackerfront.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.net.MalformedURLException;

@Controller
public class MediaListController {

    @Autowired
    MediaService mediaService;


    @GetMapping("/title/view/media")
    public String get(@RequestParam(required = false, defaultValue = "") String status,
                      Model model) throws MalformedURLException {
        var mediaList = mediaService.getAllByUsrId(3);
        model.addAttribute("mediaList", mediaList);
        model.addAttribute("nickname", "ruderu");
        return "media/view/mediaList";
    }

    @GetMapping("/title/view/edit")
    public String post(
            @RequestParam int id,
            @RequestParam String type,
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addAttribute("id", id);

        return String.format("redirect:../%s/edit", type.toLowerCase());
    }
}
