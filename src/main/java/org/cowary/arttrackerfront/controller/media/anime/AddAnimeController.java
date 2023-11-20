package org.cowary.arttrackerfront.controller.media.anime;

import org.cowary.arttrackerfront.controller.media.AddController;
import org.cowary.arttrackerfront.entity.anime.Anime;
import org.cowary.arttrackerfront.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddAnimeController implements AddController<Anime> {

    @Autowired
    AnimeService animeService;

    @Override
    @GetMapping("title/anime/add")
    public String get(
            @RequestParam(required = false) Integer integrationId,
            Model model) {
        if (integrationId != null) {
            var animeRs = animeService.findByIntegrationId(integrationId);
            model.addAttribute(animeRs.getMedia());
            model.addAttribute("add", true);
            model.addAttribute("image", "https://dere.shikimori.me" + animeRs.getPosterUrl());
        }

        return "media/anime/addAnim";
    }

    @Override
    public String post(Anime media, RedirectAttributes redirectAttributes) {
        var response = animeService.postMedia(media);
        redirectAttributes.addAttribute("i", response.getId());

        return "redirect:../anime/edit";
    }
}
