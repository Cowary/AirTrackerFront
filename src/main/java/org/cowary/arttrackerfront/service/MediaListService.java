package org.cowary.arttrackerfront.service;

import java.util.List;

public interface MediaListService<T> {


    public List<T> getAll(long userId);
    public List<T> getAll(long userId, String status);



}
