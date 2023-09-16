package org.cowary.arttrackerfront.entity.tv;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class TvIntegration {


    private Long id;
    private String name;
    private Long idTv;
    private Long idIntegration;

    public TvIntegration(String name, Long idTv, Long idIntegration) {
        this.name = name;
        this.idTv = idTv;
        this.idIntegration = idIntegration;
    }

    public TvIntegration() {
    }
}
