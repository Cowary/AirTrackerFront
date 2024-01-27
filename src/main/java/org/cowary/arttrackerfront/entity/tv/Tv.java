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

public class Tv extends Media {


    private Long id;
    private String originalTitle;
    private String title;
    private Integer releaseYear;
    private Integer score;
    private Integer seasons;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpd;
    private Long usrId;
    private Integer integrationId;
    private String type = "Tv";

    public Tv(String originalTitle, String title, Integer releaseYear, Integer seasons) {
        this.originalTitle = originalTitle;
        this.title = title;
        this.releaseYear = releaseYear;
        this.seasons = seasons;
    }

    public Tv() {
    }
}
