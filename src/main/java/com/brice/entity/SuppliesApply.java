package com.brice.entity;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * 物资申请实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class SuppliesApply {
    /**
     * id
     */
    private Long id;
    /**
     * 身份证
     */
    private Long residentId;
    /**
     * 物资id
     */
    private Long suppliesId;
    /**
     * 物资数量
     */
    private Integer number;
    /**
     * 申请时间
     */
    private LocalDateTime applyTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 回复内容
     */
    private String reply;
}
