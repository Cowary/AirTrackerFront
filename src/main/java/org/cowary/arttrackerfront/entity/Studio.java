package org.cowary.arttrackerfront.entity;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Studio {


    private Long id;
    private String name;
    private String filteredName;
    private String image;

    public Studio(String name, String filteredName, String image) {
        this.name = name;
        this.filteredName = filteredName;
        this.image = image;
    }

    public Studio(String name) {
        this.name = name;
    }

    public Studio() {
    }

}
