package org.cowary.arttrackerfront.entity.api.mediaRs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.cowary.arttrackerfront.entity.ranobe.Ranobe;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RanobeRs implements MediaRs {

    private Ranobe ranobe;
    private String posterUrl;
}
