package org.cowary.arttrackerfront.entity.anime;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AnimeRole {


    private Long id;
    private String nameEn;
    private String nameRu;
    private Long animeId;
    private Long personId;

    public AnimeRole(String nameEn, String nameRu, Long animeId, Long personId) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.animeId = animeId;
        this.personId = personId;
    }

    public AnimeRole() {
    }
}
