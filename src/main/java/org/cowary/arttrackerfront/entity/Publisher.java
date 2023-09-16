package org.cowary.arttrackerfront.entity;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Publisher {


    private Long id;
    private String name;

    public Publisher(String name) {
        this.name = name;
    }

    public Publisher() {
    }
}
