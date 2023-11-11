package org.cowary.arttrackerfront.controller.media;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface FindController<T> {

    String get();
    String find(@ModelAttribute T media, Model model);
    String save(@RequestParam long id, RedirectAttributes redirectAttributes);
}
