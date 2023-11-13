package org.cowary.arttrackerfront.entity.game;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cowary.arttrackerfront.entity.Media;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString

public class Game extends Media {


    private Long id;
    private String title;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private Integer releaseYear;
    private Integer score;
    private String status;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastUpd;
    private Long usrId;
    
    private String type = "Game";

}
