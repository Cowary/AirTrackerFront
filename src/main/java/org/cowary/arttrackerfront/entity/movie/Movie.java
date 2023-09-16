package org.cowary.arttrackerfront.entity.movie;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cowary.arttrackerfront.entity.Media;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString

public class Movie extends Media {


    private Long id;
    private String originalTitle;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    
    private Date releaseDate;
    private Integer releaseYear;
    private Integer duration;
    private String status;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    
    private Date endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    
    private Date lastUpd;
    private Long usrId;
    
    private String type = "Movie";

    public Movie(String originalTitle, String title, int releaseYear, Integer duration) {
        this.originalTitle = originalTitle;
        this.title = title;
        this.releaseYear = releaseYear;
        this.duration = duration;
    }

    public Movie() {

    }
}