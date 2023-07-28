package ru.sber.kapustin.homework6.library.model;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String phone;
    private String email;
    private String[] books;
}


