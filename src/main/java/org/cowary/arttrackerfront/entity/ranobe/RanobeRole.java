package org.cowary.arttrackerfront.entity.ranobe;






import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class RanobeRole {


    private Long id;
    private String nameEn;
    private String nameRu;
    private Long ranobeId;
    private Long personId;

    public RanobeRole(String nameEn, String nameRu, Long ranobeId, Long personId) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.ranobeId = ranobeId;
        this.personId = personId;
    }

    public RanobeRole() {
    }
}
