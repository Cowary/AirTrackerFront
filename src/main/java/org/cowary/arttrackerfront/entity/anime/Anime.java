package org.cowary.arttrackerfront.entity.anime;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cowary.arttrackerfront.entity.Media;
import org.cowary.arttrackerfront.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString

public class Anime extends Media {


    private Long id;
    private String originalTitle;
    private String title;
    private Integer episodes;
    private String status;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private Integer releaseYear;
    private Long shikiId;
    private Integer duration;
    private Integer episodesEnd;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpd;
    private Long usrId;
    private String type = "Anime";

    public Anime(String originalTitle, String title, Integer episodes, LocalDate releaseDate, Long shikiId, Integer duration) {
        this.originalTitle = originalTitle;
        this.title = title;
        this.episodes = episodes;
        this.releaseDate = releaseDate;
        this.releaseYear = DateUtil.getYear(releaseDate);
        this.shikiId = shikiId;
        this.duration = duration;
    }

    public Anime(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public Anime() {
    }
}
