package org.cowary.arttrackerfront.controller.media.controller;

import org.cowary.arttrackerfront.controller.media.AddController;
import org.cowary.arttrackerfront.controller.media.EditController;
import org.cowary.arttrackerfront.controller.media.FindController;
import org.cowary.arttrackerfront.entity.tv.Tv;
import org.cowary.arttrackerfront.entity.tv.TvSeason;
import org.cowary.arttrackerfront.service.TvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("/title/tv")
public class TvController implements AddController<TvSeason>, EditController<TvSeason>, FindController<TvSeason> {

    @Autowired
    private TvService tvService;

    @Override
    @GetMapping("/add")
    public String add(@RequestParam(required = false) Integer integrationId, Model model) {
        if (integrationId != null) {
            var tvRs = tvService.findByIntegrationId(integrationId);
            model.addAttribute("tv", tvRs.getTv());
            model.addAttribute("add", true);
            model.addAttribute("image", tvRs.getPosterUrl());
        }
        return "media/tv/add";
    }

    @Override
    public String save(TvSeason media, RedirectAttributes redirectAttributes) {
        return null;
    }

    //@Override
    @PostMapping("/add")
    public String save(@RequestParam String titleTvSeason, @RequestParam String titleTv, @RequestParam(required = false) Long tvSeasonId, @RequestParam(required = false) Long tvId,
                       @ModelAttribute("tvSeason") TvSeason media, @ModelAttribute("tv") Tv tv, RedirectAttributes redirectAttributes) {
        System.out.println(tvId + " : " + titleTv);
        System.out.println(tvSeasonId + " : " + titleTvSeason);
        tv.setId(tvId);
        tv.setTitle(titleTv);
        media.setTv(tv);
        media.setId(tvSeasonId);
        media.setTitle(titleTvSeason);

        System.out.println(media);
        var response = tvService.postMedia(media);
        redirectAttributes.addAttribute("id", response.getId());
        return "redirect:../tv/edit";
    }

    @Override
    @GetMapping("/edit")
    public String get(@RequestParam long id, Model model) {
        var tvSeason = tvService.getMedia(id);
        model.addAttribute("tvSeason", tvSeason);
        model.addAttribute("tv", tvSeason.getTv());
        model.addAttribute("edit", true);
        return "media/tv/add";
    }

    @Override
    public String saveOrUpdate(TvSeason media) {
        return null;
    }

    @PostMapping("/edit")
    public String saveOrUpdate(@ModelAttribute("tvSeason") TvSeason media, @ModelAttribute("tv")Tv tv) {
        media.setTv(tv);
        System.out.println(media);
        tvService.putMedia(media);
        return "redirect:../view/media";
    }

    @Override
    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        tvService.deleteMedia(id);
        return "redirect:../view/media";
    }

    @Override
    @GetMapping("/find")
    public String searchPage() {
        return "media/tv/find";
    }

    @Override
//    @PostMapping("/find")
    public String search(@ModelAttribute TvSeason media, Model model) {
        Objects.requireNonNull(media.getTitle());
        var list = tvService.find(media.getTitle());
        model.addAttribute("list", list.getFindMedia());
        return "media/tv/find";
    }

    @PostMapping("/find")
    public String search(String keyword, Model model) {
        Objects.requireNonNull(keyword);
        var list = tvService.find(keyword);
        model.addAttribute("list", list.getFindMedia());
        return "media/tv/find";
    }

    @Override
    @PostMapping("/saveTv")
    public String save(long integrationId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("integrationId", integrationId);
        return "redirect:./add";
    }
}
