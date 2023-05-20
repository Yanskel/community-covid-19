package com.brice.entity;

import java.util.List;

import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;

/**
 * 菜单实体类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Data
public class Menu {
    /**
     * id
     */
    private Long id;
    /**
     * 菜单路径
     */
    private String path;
    /**
     * 菜单名
     */
    private String name;
    /**
     * 菜单标签
     */
    private String label;
    /**
     * 菜单图标
     */
    private String icon;
    /**
     * 菜单等级
     */
    private String level;
    /**
     * 父级菜单
     */
    private Long parent;
    /**
     * 角色
     */
    private Integer role;
    /**
     * 菜单url
     */
    private String url;
    /**
     * 子菜单
     */
    @TableField(exist = false)
    private List<Menu> children;
}
