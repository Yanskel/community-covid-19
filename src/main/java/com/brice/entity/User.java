package com.brice.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class User implements Serializable {
    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;
    /**
     * id
     */
    @ExcelIgnore
    private Long id;
    /**
     * 用户名
     */
    @ExcelProperty(value = "用户名", index = 0)
    private String username;
    /**
     * 密码
     */
    @ExcelProperty(value = "密码", index = 1)
    private String password;
    /**
     * 名字
     */
    @ExcelProperty(value = "姓名", index = 2)
    private String name;
    /**
     * 电话
     */
    @ExcelProperty(value = "手机号", index = 3)
    private String phone;
    /**
     * 身份证号码
     */
    @ExcelProperty(value = "身份证", index = 4)
    private String idNumber;
    /**
     * 小区id
     */
    @ExcelIgnore
    private Long acId;
    /**
     * 地址
     */
    @ExcelProperty(value = "家庭住址", index = 6)
    private String address;
    /**
     * 账号状态
     */
    @ExcelIgnore
    private Integer status;
    /**
     * 角色
     */
    @ExcelIgnore
    private Integer role;
}
