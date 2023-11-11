package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.findRs.FindMediaRs;

public interface FindService<T> {

    FindMediaRs find(String keyword);
    T getByMediaId(long id);
}
