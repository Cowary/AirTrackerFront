package org.cowary.arttrackerfront.controller.list;

import org.cowary.arttrackerfront.UserService;
import org.cowary.arttrackerfront.util.ApiUrl;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
public class MediaListController {

    @Autowired
    UserService userService;
    @Autowired
    RestTemp restTemp;

    @GetMapping("/title/view/media")
    public String get(@RequestParam(required = false, defaultValue = "") String status,
                      Model model) {


        String nickname = userService.getNameCurrentUser();
        model.addAttribute("nickname", nickname);
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(userService.getCurrentUserToken());
        headers.set("id", );


        List<Objects> mediaList = restTemp.getRest()


        List<Media> mediaList = new ArrayList<>();
        mediaList.addAll(animeCrud.getAll(status));
        mediaList.addAll(mangaCrud.getAll(status));
        mediaList.addAll(ranobeVolumeCrud.getAll(status));
        mediaList.addAll(movieCrud.getAll(status));
        mediaList.addAll(gameCrud.getAll(status));
        mediaList.addAll(bookCrud.getAll(status));
        mediaList.addAll(tvSeasonsCrud.getAll(status));

        mediaList = mediaList.stream()
                .sorted((o1, o2) -> new Media().getComparator().compare(o1, o2))
                .collect(Collectors.toList());

        model.addAttribute("mediaList", mediaList);
        model.addAttribute(nickname);
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
