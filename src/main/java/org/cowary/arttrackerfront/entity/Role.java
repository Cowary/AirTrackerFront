package org.cowary.arttrackerfront.entity;



import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Getter
@Setter
@ToString

public class Role {

    
    private Long id;
    private String name;
    private Set<User> users;

    public Role() {
    }

    public Role(Long id) {
        this.id = id;
    }

    public Role(Long id, String name) {
        this.id = id;
        this.name = name;
    }

//    @Override
//    public String getAuthority() {
//        return getName();
//    }


}
