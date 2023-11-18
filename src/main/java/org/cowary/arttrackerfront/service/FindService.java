package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.findRs.FindMediaRs;

public interface FindService<T> {

    FindMediaRs find(String keyword);
    T findByIntegrationId(long id);
    String getPosterUrl(int id);
}
