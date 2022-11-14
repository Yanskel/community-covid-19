package com.brice.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String idNumber;
    private Long acId;
    private Integer status;
    private Integer role;
}
