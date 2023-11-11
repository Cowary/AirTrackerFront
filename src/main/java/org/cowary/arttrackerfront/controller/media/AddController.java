package org.cowary.arttrackerfront.controller.media;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface AddController<T> {

    String get(@RequestParam(required = false) Integer id, Model model);
    String post(@ModelAttribute T media, RedirectAttributes redirectAttributes);
}
