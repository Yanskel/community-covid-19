package com.brice.controller;

import com.brice.common.R;
import com.brice.entity.Menu;
import com.brice.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
