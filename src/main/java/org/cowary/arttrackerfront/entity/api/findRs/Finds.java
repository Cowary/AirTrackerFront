package org.cowary.arttrackerfront.entity.api.findRs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Finds {

    private String nameEn;
    private String nameRu;
    private String score;
    private Integer episodes;
    private Integer year;
    private Integer integrationId;
}
