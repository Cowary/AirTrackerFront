package org.cowary.arttrackerfront.entity.ranobe;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cowary.arttrackerfront.entity.Media;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@ToString

public class RanobeVolume extends Media {


    private Long id;
    private String title;
    private Integer chapters;
    private Integer chaptersEnd;
    private String status;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastUpd;
    private Long ranobeId;
    private Long usrId;
    private String originalTitle;
    private Integer volumes;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private Integer releaseYear;
    private Integer volumesEnd;

    private static final String type = "Ranobe";

    public void setCommonField(Ranobe ranobe) {
        originalTitle = ranobe.getOriginalTitle();
        volumes = ranobe.getVolumes();
        releaseDate = ranobe.getReleaseDate();
        releaseYear = ranobe.getReleaseYear();
        volumesEnd = ranobe.getVolumesEnd();
    }
}
