package com.project.atm.entity;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Data
public class JwtRequest {

    private String username;
    private String password;


}
