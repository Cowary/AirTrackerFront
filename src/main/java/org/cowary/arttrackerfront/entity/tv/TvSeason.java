package org.cowary.arttrackerfront.entity.tv;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cowary.arttrackerfront.entity.Media;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString

public class TvSeason extends Media {


    private Long id;
    private String title;
    private Integer episodes;
    private Integer episodesEnd;
    private String status;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    
    private Date endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    
    private Date lastUpd;
    private Long tvId;
    private Long usrId;

    
    private String originalTitle;
    
    private Integer seasons;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    
    private Date releaseDate;
    
    private Integer releaseYear;
    
    private Integer seasonsEnd;
    
    private static final String type = "Tv";

    public void setCommonField(Tv tv) {
        originalTitle = tv.getOriginalTitle();
        seasons = tv.getSeasons();
        releaseDate = tv.getReleaseDate();
        releaseYear = tv.getReleaseYear();
        seasonsEnd = tv.getSeasonsEnd();
    }
}
