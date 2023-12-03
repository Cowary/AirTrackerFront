package org.cowary.arttrackerfront.entity.api.mediaRs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cowary.arttrackerfront.entity.tv.Tv;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TvRs implements MediaRs {

    private Tv tv;
    private String posterUrl;
}
