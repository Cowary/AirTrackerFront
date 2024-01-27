package org.cowary.arttrackerfront.entity.tv;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cowary.arttrackerfront.entity.Media;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString

public class TvSeason extends Media {


    private Long id;
    private String title;
    private Integer number;
    private String status;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpd;
    private Long tvId;
    private Long usrId;
    private Integer releaseYear;

    private static final String type = "Tv";
}
