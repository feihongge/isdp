package edu.scau.mis_pos.domain;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class LoginUser {
    private String avatar;
    private String userName;
    private String password;
    private String token;
}
