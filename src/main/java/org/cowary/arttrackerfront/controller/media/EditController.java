package org.cowary.arttrackerfront.controller.media;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface EditController<T> {

    String get(long id, Model model);
    String saveOrUpdate(@ModelAttribute T media);
    String delete(@RequestParam() long id);
}
