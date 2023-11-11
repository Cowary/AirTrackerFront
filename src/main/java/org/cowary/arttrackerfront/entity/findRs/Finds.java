package org.cowary.arttrackerfront.entity.findRs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Finds {

    private String nameEn;
    private String nameRu;
    private String score;
    private Integer episodes;
    private Integer year;
    private Integer shikiId;
}
