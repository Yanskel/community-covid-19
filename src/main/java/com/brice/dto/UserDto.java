package com.brice.dto;

import com.brice.entity.User;
import lombok.Data;

@Data
public class UserDto extends User {
    private String acName;
}
