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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private Integer releaseYear;
    private String status;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private Integer seasons;
    private Integer seasonsEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpd;
    private Long usrId;
    
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
