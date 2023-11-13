package org.cowary.arttrackerfront.controller.list;

import org.cowary.arttrackerfront.service.MediaListServiceImlp;
import org.cowary.arttrackerfront.util.SystemUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReadListController {

    @Autowired
    private MediaListServiceImlp mediaListServiceImlp;

    @GetMapping("title/view/read")
    public String get(@RequestParam(required = false, defaultValue = "") String status,
                      Model model) {
        var mediaList = mediaListServiceImlp.getReadListByUserId(SystemUtil.getUserid(), status);
        model.addAttribute("mediaList", mediaList);
        model.addAttribute("nickname", "ruderu");
        return "media/view/read";
    }
}
