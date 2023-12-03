package org.cowary.arttrackerfront.controller.media.controller.anime;

import org.cowary.arttrackerfront.controller.media.EditController;
import org.cowary.arttrackerfront.entity.anime.Anime;
import org.cowary.arttrackerfront.service.AnimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EditAnimeController implements EditController<Anime> {

    @Autowired
    private AnimeService animeService;

    @Override
    @GetMapping("/title/anime/edit")
    public String get(
            @RequestParam long id,
            Model model
    ) {
        var anime = animeService.getMedia(id);

        model.addAttribute("anime", anime);
        model.addAttribute("edit", true);

        return "media/anime/addAnim";
    }

    @Override
    @PostMapping("/title/anime/edit")
    public String saveOrUpdate(
            @ModelAttribute("anime") Anime media)
    {
        animeService.putMedia(media);

        return "redirect:../view/media";
    }

    @Override
    @PostMapping("/title/anime/delete")
    public String delete(
            @RequestParam() long id
    ) {
        animeService.deleteMedia(id);

        return "redirect:../view/media";
    }
}
