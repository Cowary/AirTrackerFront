package org.cowary.arttrackerfront.entity.manga;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MangaRole {


    private Long id;
    private String nameEn;
    private String nameRu;
    private Long mangaId;
    private Long personId;

    public MangaRole(String nameEn, String nameRu, Long mangaId, Long personId) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.mangaId = mangaId;
        this.personId = personId;
    }

    public MangaRole() {
    }
}
