package org.cowary.arttrackerfront.entity.movie;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MovieIntegration {


    private Long id;
    private String name;
    private Long idMovie;
    private Long idIntegration;

    public MovieIntegration(String name, Long idMovie, Long idIntegration) {
        this.name = name;
        this.idMovie = idMovie;
        this.idIntegration = idIntegration;
    }

    public MovieIntegration() {
    }
}
