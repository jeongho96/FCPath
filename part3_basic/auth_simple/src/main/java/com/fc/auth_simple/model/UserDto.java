package com.fc.auth_simple.model;


import lombok.*;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private String name;

    private String password;
}
