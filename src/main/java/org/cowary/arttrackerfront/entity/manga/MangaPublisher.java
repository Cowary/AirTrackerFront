package org.cowary.arttrackerfront.entity.manga;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MangaPublisher {


    private Long id;
    private Long mangaId;
    private Long publisherId;

    public MangaPublisher(Long mangaId, Long publisherId) {
        this.mangaId = mangaId;
        this.publisherId = publisherId;
    }

    public MangaPublisher() {
    }
}
