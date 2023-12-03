package org.cowary.arttrackerfront.controller.media;

import org.cowary.arttrackerfront.entity.Media;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

public interface EditController<T extends Media> {

    String get(long id, Model model);
    String saveOrUpdate(@ModelAttribute T media);
    String delete(@RequestParam() long id);
}
