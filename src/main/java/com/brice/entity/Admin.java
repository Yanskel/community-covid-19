package com.brice.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 管理员实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class Admin implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;
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
