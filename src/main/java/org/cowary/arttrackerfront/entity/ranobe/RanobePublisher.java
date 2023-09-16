package org.cowary.arttrackerfront.entity.ranobe;





import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class RanobePublisher {


    private Long id;
    private Long ranobeId;
    private Long publisherId;

    public RanobePublisher(Long ranobeId, Long publisherId) {
        this.ranobeId = ranobeId;
        this.publisherId = publisherId;
    }

    public RanobePublisher() {
    }
}
