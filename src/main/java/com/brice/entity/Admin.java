package com.brice.entity;

import lombok.Data;

/**
 * 管理员实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class Admin {
    /**
     * id
     */
    private Long id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
}
