package org.cowary.arttrackerfront.entity.movie;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class MovieProduction {


    private Long id;
    private Long movieId;
    private Long productionId;

    public MovieProduction(Long movieId, Long productionId) {
        this.movieId = movieId;
        this.productionId = productionId;
    }

    public MovieProduction() {
    }
}
