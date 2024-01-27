package org.cowary.arttrackerfront.controller.media.controller;

import org.cowary.arttrackerfront.controller.media.AddController;
import org.cowary.arttrackerfront.controller.media.EditController;
import org.cowary.arttrackerfront.controller.media.FindController;
import org.cowary.arttrackerfront.entity.manga.Manga;
import org.cowary.arttrackerfront.service.MangaService;
import org.cowary.arttrackerfront.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("/title/manga")
public class MangaController implements AddController<Manga>, EditController<Manga>, FindController<Manga> {

    @Autowired
    private MangaService mangaService;

    @Override
    @GetMapping("/add")
    public String add(@RequestParam(required = false) Integer integrationId, Model model) {
        if (integrationId != null) {
            var mangaRs = mangaService.findByIntegrationId(integrationId);
            model.addAttribute(mangaRs.getManga());
            model.addAttribute("add", true);
            model.addAttribute("image", Config.getShikiUrl() + mangaRs.getPosterUrl());
        }
        return "media/manga/addManga";
    }

    @Override
    @PostMapping("/add")
    public String save(Manga media, RedirectAttributes redirectAttributes) {
        var response = mangaService.postMedia(media);
        redirectAttributes.addAttribute("id", response.getId());
        return "redirect:../manga/edit";
    }

    @Override
    @GetMapping("/edit")
    public String get(@RequestParam long id, Model model) {
        var manga = mangaService.getMedia(id);
        model.addAttribute("manga", manga);
        model.addAttribute("edit", true);
        return "media/manga/addManga";
    }

    @Override
    @PostMapping("/edit")
    public String saveOrUpdate(@ModelAttribute("manga") Manga media) {
        mangaService.putMedia(media);
        return "redirect:../view/media";
    }

    @Override
    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        mangaService.deleteMedia(id);
        return "redirect:../view/media";
    }

    @Override
    @GetMapping("/find")
    public String searchPage() {
        return "media/manga/findManga";
    }

    @Override
    @PostMapping("/find")
    public String search(@ModelAttribute("manga") Manga media, Model model) {
        Objects.requireNonNull(media.getOriginalTitle());
        var list = mangaService.find(media.getOriginalTitle());
        model.addAttribute("list", list.getFindMedia());
        return "media/manga/findManga";
    }

    @Override
    @PostMapping("/saveManga")
    public String save(long integrationId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("integrationId", integrationId);
        return "redirect:./add";
    }
}
