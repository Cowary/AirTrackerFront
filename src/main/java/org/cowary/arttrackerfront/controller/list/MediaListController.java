package org.cowary.arttrackerfront.controller.list;

import org.cowary.arttrackerfront.config.UserService;
import org.cowary.arttrackerfront.service.AnimeService;
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
    AnimeService animeService;


    @GetMapping("/title/view/media")
    public String get(@RequestParam(required = false, defaultValue = "") String status,
                      Model model) throws MalformedURLException {


        var mediaList = animeService.getAllByUsrId(3);
        System.out.println(mediaList);


//        List<Media> mediaList = new ArrayList<>();
//        mediaList.addAll(animeCrud.getAll(status));
//        mediaList.addAll(mangaCrud.getAll(status));
//        mediaList.addAll(ranobeVolumeCrud.getAll(status));
//        mediaList.addAll(movieCrud.getAll(status));
//        mediaList.addAll(gameCrud.getAll(status));
//        mediaList.addAll(bookCrud.getAll(status));
//        mediaList.addAll(tvSeasonsCrud.getAll(status));
//
//        mediaList = mediaList.stream()
//                .sorted((o1, o2) -> new Media().getComparator().compare(o1, o2))
//                .collect(Collectors.toList());

        model.addAttribute("mediaList", mediaList);
        model.addAttribute("");
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