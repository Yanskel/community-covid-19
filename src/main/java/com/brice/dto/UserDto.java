package com.brice.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.brice.entity.User;
import lombok.Data;

@Data
public class UserDto extends User {
    @ExcelProperty(value = "居住小区" ,index = 5)
    private String acName;
    @ExcelProperty(value = "账号状态" ,index = 7)
    private String accountStatus;
}
