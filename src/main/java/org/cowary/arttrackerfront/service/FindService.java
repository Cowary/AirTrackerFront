package org.cowary.arttrackerfront.service;

import org.cowary.arttrackerfront.entity.api.findRs.FindMediaRs;
import org.cowary.arttrackerfront.entity.api.mediaRs.MediaRs;

public interface FindService<T extends MediaRs> {

    FindMediaRs find(String keyword);
    T findByIntegrationId(long id);
}
