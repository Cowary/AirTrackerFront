package org.cowary.arttrackerfront.entity;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Person {


    private Long id;
    private String nameEn;
    private String nameRu;
    private int integrationId;

    public Person(String nameEn, String nameRu, int integrationId) {
        this.nameEn = nameEn;
        this.nameRu = nameRu;
        this.integrationId = integrationId;
    }

    public Person() {
    }
}
