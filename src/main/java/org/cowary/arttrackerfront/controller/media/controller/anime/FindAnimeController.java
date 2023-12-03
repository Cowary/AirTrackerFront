package org.cowary.arttrackerfront.controller.media.controller.anime;

import org.cowary.arttrackerfront.controller.media.FindController;
import org.cowary.arttrackerfront.entity.anime.Anime;
import org.cowary.arttrackerfront.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
public class FindAnimeController implements FindController<Anime> {

    @Autowired
    AnimeService animeService;

    @Override
    @GetMapping("/title/anime/find")
    public String searchPage() {
        return "media/anime/findAnime";
    }

    @Override
    @PostMapping("/title/anime/find")
    public String search(
            @ModelAttribute("anime") Anime media,
            Model model
    ) {
        Objects.requireNonNull(media.getOriginalTitle());
        var list = animeService.find(media.getOriginalTitle());
        model.addAttribute("list", list.getFindMedia());

        return "media/anime/findAnime";
    }

    @Override
    @PostMapping("/title/anime/saveAnime")
    public String save(
            @RequestParam long integrationId,
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addAttribute("integrationId", integrationId);

        return "redirect:./add";
    }
}
