package org.cowary.arttrackerfront.entity.ranobe;


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

public class Ranobe extends Media {


    private Long id;
    private String originalTitle;
    private String title;
    private Integer volumes;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private Integer releaseYear;
    private Long shikiId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpd;
    private Long usrId;
    
    private static final String type = "Ranobe";

    public Ranobe(String originalTitle, String title, Integer volumes, LocalDate releaseDate, Long shikiId) {
        this.originalTitle = originalTitle;
        this.title = title;
        this.volumes = volumes;
        this.releaseDate = releaseDate;
        this.releaseYear = DateUtil.getYear(releaseDate);
        this.shikiId = shikiId;
    }

    public Ranobe() {

    }
}
