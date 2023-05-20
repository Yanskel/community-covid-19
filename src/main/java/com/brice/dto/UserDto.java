package com.brice.dto;

import com.alibaba.excel.annotation.ExcelProperty;
import com.brice.entity.User;

import lombok.Data;

/**
 * 用户dto
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class UserDto extends User {
    /**
     * 小区名称
     */
    @ExcelProperty(value = "居住小区", index = 5)
    private String acName;
    /**
     * 账号状态
     */
    @ExcelProperty(value = "账号状态", index = 7)
    private String accountStatus;
}
