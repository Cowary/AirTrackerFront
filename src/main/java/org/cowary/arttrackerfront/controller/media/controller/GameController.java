package org.cowary.arttrackerfront.controller.media.controller;

import org.cowary.arttrackerfront.controller.media.AddController;
import org.cowary.arttrackerfront.controller.media.EditController;
import org.cowary.arttrackerfront.entity.game.Game;
import org.cowary.arttrackerfront.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("title/game")
public class GameController implements AddController<Game>, EditController<Game> {

    @Autowired
    private GameService gameService;

    @Override
    @GetMapping("/add")
    public String add(@RequestParam(required = false) Integer integrationId, Model model) {
        return "media/game/add";
    }

    @Override
    @PostMapping("/add")
    public String save(@ModelAttribute Game media, RedirectAttributes redirectAttributes) {
        var response = gameService.postMedia(media);
        redirectAttributes.addAttribute("id", response.getId());
        return "redirect:../game/edit";
    }

    @Override
    @GetMapping("/edit")
    public String get(@RequestParam long id, Model model) {
        var game = gameService.getMedia(id);
        model.addAttribute("game", game);
        model.addAttribute("edit", true);
        return "media/game/add";
    }

    @Override
    @PostMapping("/edit")
    public String saveOrUpdate(@ModelAttribute Game media) {
        gameService.putMedia(media);
        return "redirect:../view/media";
    }

    @Override
    @PostMapping("/delete")
    public String delete(long id) {
        gameService.deleteMedia(id);
        return "redirect:../view/media";
    }
}
