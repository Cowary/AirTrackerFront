package org.cowary.arttrackerfront.entity.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationReq {

    private String username;
    private String password;
}
