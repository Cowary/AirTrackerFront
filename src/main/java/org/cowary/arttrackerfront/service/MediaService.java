package org.cowary.arttrackerfront.service;

public interface MediaService<T> {
    T getMedia(long titleId);
    T postMedia(T media);
    T putMedia(T media);
   String deleteMedia(long id);

}
