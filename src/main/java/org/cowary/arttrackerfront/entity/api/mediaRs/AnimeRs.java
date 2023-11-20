package org.cowary.arttrackerfront.entity.api.mediaRs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cowary.arttrackerfront.entity.anime.Anime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnimeRs implements MediaRs {

    private Anime media;
    private String posterUrl;
}
