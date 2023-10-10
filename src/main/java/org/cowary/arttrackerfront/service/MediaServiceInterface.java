package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.anime.Anime;
import org.cowary.arttrackerfront.util.Config;
import org.springframework.http.HttpHeaders;

import java.util.List;

public interface MediaServiceInterface<T> {


    public List<T> getAll(long userId);
    public List<T> getAll(long userId, String status);


}
