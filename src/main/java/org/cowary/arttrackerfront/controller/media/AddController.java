package org.cowary.arttrackerfront.controller.media;

import org.cowary.arttrackerfront.entity.Media;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface AddController<T extends Media> {

    String add(@RequestParam(required = false) Integer integrationId, Model model);
    String save(@ModelAttribute T media, RedirectAttributes redirectAttributes);
}
