package com.brice.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class User {
    @ExcelIgnore
    private Long id;
    @ExcelProperty(value = "用户名", index = 0)
    private String username;
    @ExcelProperty(value = "密码", index = 1)
    private String password;
    @ExcelProperty(value = "姓名", index = 2)
    private String name;
    @ExcelProperty(value = "手机号", index = 3)
    private String phone;
    @ExcelProperty(value = "身份证" ,index = 4)
    private String idNumber;
    @ExcelIgnore
    private Long acId;
    @ExcelIgnore
    private Integer status;
    @ExcelIgnore
    private Integer role;
}
