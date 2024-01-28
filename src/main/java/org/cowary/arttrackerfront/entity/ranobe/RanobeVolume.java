package org.cowary.arttrackerfront.entity.ranobe;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.cowary.arttrackerfront.entity.Media;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class RanobeVolume extends Media {


    private Long id;
    private String title;
    private Integer number;
    private String status;
    private Integer score;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate lastUpd;
    private Ranobe ranobe;
    private Long usrId;
    private static final String type = "Ranobe";
}
