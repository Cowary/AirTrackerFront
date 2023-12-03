package org.cowary.arttrackerfront.entity.api.mediaRs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cowary.arttrackerfront.entity.manga.Manga;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MangaRs implements MediaRs {

    private Manga manga;
    private String posterUrl;
}
