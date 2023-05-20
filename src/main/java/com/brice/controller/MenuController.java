package com.brice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brice.entity.Menu;
import com.brice.service.MenuService;

/**
 * 菜单Controller
 *
 * @author Brice
 * @date 2023/05/20
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    /**
     * 查询菜单
     *
     * @param role 身份
     * @return 菜单
     */
    @GetMapping
    public List<Menu> getAll(Integer role) {
        return menuService.getAll(role);
    }
}
