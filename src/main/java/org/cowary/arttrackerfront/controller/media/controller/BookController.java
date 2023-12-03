package org.cowary.arttrackerfront.controller.media.controller;

import org.cowary.arttrackerfront.controller.media.AddController;
import org.cowary.arttrackerfront.controller.media.EditController;
import org.cowary.arttrackerfront.entity.book.Book;
import org.cowary.arttrackerfront.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/title/book")
public class BookController implements AddController<Book>, EditController<Book> {

    @Autowired
    private BookService bookService;

    @Override
    @GetMapping("/add")
    public String add(@RequestParam(required = false) Integer integrationId, Model model) {
        return "media/book/add";
    }

    @Override
    @PostMapping("/add")
    public String save(Book media, RedirectAttributes redirectAttributes) {
        var response = bookService.postMedia(media);
        redirectAttributes.addAttribute("id", response.getId());
        return "redirect:../book/edit";
    }

    @Override
    @GetMapping("/edit")
    public String get(@RequestParam long id, Model model) {
        var book = bookService.getMedia(id);
        model.addAttribute("book", book);
        model.addAttribute("edit", true);
        return "media/book/add";
    }

    @Override
    @PostMapping("/edit")
    public String saveOrUpdate(@ModelAttribute("book") Book media) {
        bookService.putMedia(media);
        return "redirect:../view/media";
    }

    @Override
    @PostMapping("/delete")
    public String delete(@RequestParam long id) {
        bookService.deleteMedia(id);
        return "redirect:../view/media";
    }
}
