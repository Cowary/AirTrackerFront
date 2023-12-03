package org.cowary.arttrackerfront.controller.media.controller;

import org.cowary.arttrackerfront.controller.media.AddController;
import org.cowary.arttrackerfront.controller.media.EditController;
import org.cowary.arttrackerfront.controller.media.FindController;
import org.cowary.arttrackerfront.entity.movie.Movie;
import org.cowary.arttrackerfront.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;

@Controller
@RequestMapping("/title/movie")
public class MovieController implements AddController<Movie>, EditController<Movie>, FindController<Movie> {

    @Autowired
    private MovieService movieService;

    @Override
    @GetMapping("/add")
    public String add(@RequestParam(required = false) Integer integrationId, Model model) {
        if (integrationId != null) {
            var movieRs = movieService.findByIntegrationId(integrationId);
            model.addAttribute(movieRs.getMovie());
            model.addAttribute("add", true);
            model.addAttribute("image", movieRs.getPosterUrl());
        }
        return "media/movie/add";
    }

    @Override
    @PostMapping("/add")
    public String save(Movie media, RedirectAttributes redirectAttributes) {
        var response = movieService.postMedia(media);
        return "redirect:../movie/edit";
    }

    @Override
    @GetMapping("/edit")
    public String get(@RequestParam long id, Model model) {
        var movie = movieService.getMedia(id);

        model.addAttribute("movie", movie);
        model.addAttribute("edit", true);
        return "media/movie/add";
    }

    @Override
    @PostMapping("/edit")
    public String saveOrUpdate(@ModelAttribute Movie media) {
        movieService.putMedia(media);
        return "redirect:../view/media";
    }

    @Override
    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        movieService.deleteMedia(id);
        return "redirect:../view/media";
    }

    @Override
    @GetMapping("/find")
    public String searchPage() {
        return "media/movie/find";
    }

    @Override
    @PostMapping("/find")
    public String search(@ModelAttribute Movie media, Model model) {
        Objects.requireNonNull(media.getOriginalTitle());
        var list = movieService.find(media.getOriginalTitle());
        model.addAttribute("list", list.getFindMedia());
        return "media/movie/find";
    }

    @Override
    @PostMapping("/save")
    public String save(@RequestParam long id, RedirectAttributes redirectAttributes) {
        redirectAttributes.addAttribute("integrationId", id);
        return "redirect:./add";
    }
}
