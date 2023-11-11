package org.cowary.arttrackerfront.controller.media.anime;

import org.cowary.arttrackerfront.controller.media.AddController;
import org.cowary.arttrackerfront.entity.anime.Anime;
import org.cowary.arttrackerfront.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public class AddAnimeController implements AddController<Anime> {

    @Autowired
    AnimeService animeService;

    @Override
    public String get(Integer id, Model model) {
        return null;
    }

    @Override
    public String post(Anime media, RedirectAttributes redirectAttributes) {
        return null;
    }
}
