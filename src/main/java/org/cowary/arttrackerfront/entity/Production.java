package org.cowary.arttrackerfront.entity;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Production {


    private Long id;
    private String name;
    private Long tmdbId;

    public Production(String name) {
        this.name = name;
    }

    public Production() {
    }
}
