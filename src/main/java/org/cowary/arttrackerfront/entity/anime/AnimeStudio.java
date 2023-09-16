package org.cowary.arttrackerfront.entity.anime;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AnimeStudio {


    private Long id;
    private Long animeId;
    private Long studioId;


    public AnimeStudio(Long animeId, Long studioId) {
        this.animeId = animeId;
        this.studioId = studioId;
    }

    public AnimeStudio() {
    }

}
