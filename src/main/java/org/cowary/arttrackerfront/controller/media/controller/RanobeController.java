package org.cowary.arttrackerfront.controller.media.controller;

import org.cowary.arttrackerfront.controller.media.AddController;
import org.cowary.arttrackerfront.controller.media.EditController;
import org.cowary.arttrackerfront.controller.media.FindController;
import org.cowary.arttrackerfront.entity.ranobe.Ranobe;
import org.cowary.arttrackerfront.entity.ranobe.RanobeVolume;
import org.cowary.arttrackerfront.service.RanobeService;
import org.cowary.arttrackerfront.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("/title/ranobe")
public class RanobeController implements AddController<RanobeVolume>, EditController<RanobeVolume>, FindController<RanobeVolume> {

    @Autowired
    private RanobeService ranobeService;

    @Override
    @GetMapping("/add")
    public String add(@RequestParam(required = false) Integer integrationId, Model model) {
        if (integrationId != null) {
            var ranobeRs = ranobeService.findByIntegrationId(integrationId);
            //model.addAttribute("ranobeVolume", ranobeRs.getRanobe());
            model.addAttribute("ranobe", ranobeRs.getRanobe());
            model.addAttribute("add", true);
            model.addAttribute("image", Config.getShikiUrl() + ranobeRs.getPosterUrl());
        }
        return "media/ranobe/addRanobe";
    }

    @Override
    public String save(RanobeVolume media, RedirectAttributes redirectAttributes) {
        return null;
    }

    //@Override
    @PostMapping("/add")
    public String save(@RequestParam String titleVolume, @RequestParam String titleRanobe, @RequestParam(required = false) Long ranobeVolumeId,  @RequestParam(required = false) Long ranobeId,
            @ModelAttribute("ranobeVolume") RanobeVolume media, @ModelAttribute("ranobe") Ranobe ranobe, RedirectAttributes redirectAttributes) {
        System.out.println(ranobeId + " : " + titleRanobe);
        System.out.println(ranobeVolumeId + " : " + titleVolume);
        ranobe.setId(ranobeId);
        ranobe.setTitle(titleRanobe);
        media.setRanobe(ranobe);
        media.setId(ranobeVolumeId);
        media.setTitle(titleVolume);

        System.out.println(media);
        var response = ranobeService.postMedia(media);
        redirectAttributes.addAttribute("id", response.getId());
        return "redirect:../ranobe/edit";
    }

    @Override
    @GetMapping("/edit")
    public String get(@RequestParam long id, Model model) {
        var ranobeVolume = ranobeService.getMedia(id);
        model.addAttribute("ranobeVolume", ranobeVolume);
        model.addAttribute("ranobe", ranobeVolume.getRanobe());
        model.addAttribute("edit", true);
        return "media/ranobe/addRanobe";
    }

    @Override
    public String saveOrUpdate(RanobeVolume media) {
        return null;
    }

    @PostMapping("/edit")
    public String saveOrUpdate(@ModelAttribute("ranobeVolume") RanobeVolume media, @ModelAttribute("ranobe")Ranobe ranobe) {
        media.setRanobe(ranobe);
        System.out.println(media);
        ranobeService.putMedia(media);
        return "redirect:../view/media";
    }

    @Override
    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        ranobeService.deleteMedia(id);
        return "redirect:../view/media";
    }

    @Override
    @GetMapping("/find")
    public String searchPage() {
        return "media/ranobe/findRanobe";
    }

    @Override
    @PostMapping("/find")
    public String search(@ModelAttribute("ranobeVolume") RanobeVolume media, Model model) {
        Objects.requireNonNull(media.getTitle());
        var list = ranobeService.find(media.getTitle());
        model.addAttribute("list", list.getFindMedia());
        return "media/ranobe/findRanobe";
    }

    @Override
    @PostMapping("/saveRanobe")
    public String save(long integrationId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("integrationId", integrationId);
        return "redirect:./add";
    }
}
