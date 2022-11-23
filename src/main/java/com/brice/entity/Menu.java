package com.brice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Long id;
    private String path;
    private String name;
    private String label;
    private String icon;
    private String level;
    private Long parent;
    private Integer role;
    private String url;
    @TableField(exist = false)
    private List<Menu> children;
}
