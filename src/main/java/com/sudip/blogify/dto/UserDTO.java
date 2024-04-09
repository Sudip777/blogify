package com.sudip.blogify.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

        private int id;
        private String name;
        private String email;
        private String password;
        private String about;


}