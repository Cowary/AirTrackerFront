package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.config.ConfigApp;
import org.cowary.arttrackerfront.entity.book.Book;
import org.cowary.arttrackerfront.util.Config;
import org.cowary.arttrackerfront.util.RestTemp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BookService implements MediaService<Book> {

    @Autowired
    private RestTemp restTemp;
    @Autowired
    private ConfigApp configApp;
    private final String PATH = "/title/book";

    @Override
    public Book getMedia(long titleId) {
        var response = restTemp.getWithQuery(
                configApp.getBackUrl() + PATH + "/" + titleId, Book.class
        );
        return response.getBody();
    }

    @Override
    public Book postMedia(Book media) {
        var response = restTemp.postWithToken(
                configApp.getBackUrl() + PATH, media, Book.class
        );
        return response.getBody();
    }

    @Override
    public Book putMedia(Book media) {
        var response = restTemp.put(
                configApp.getBackUrl() + PATH, media, Book.class
        );
        return response.getBody();
    }

    @Override
    public String deleteMedia(long id) {
        var response = restTemp.delete(
                configApp.getBackUrl() + PATH, Map.of("id", id), String.class
        );
        return response.getBody();
    }
}
