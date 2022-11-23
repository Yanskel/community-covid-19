package com.brice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.Menu;
import com.brice.mapper.MenuMapper;
import com.brice.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {
    @Override
    public List<Menu> getAll(Integer role) {
        LambdaQueryWrapper<Menu> queryWrapper = new LambdaQueryWrapper<>();
        //查询对应身份的菜单
        queryWrapper.eq(role != null, Menu::getRole, role);
        //查询一级菜单
        queryWrapper.eq(Menu::getLevel, 0);
        List<Menu> menus = this.list(queryWrapper);
        for (Menu menu : menus) {
            LambdaQueryWrapper<Menu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
            lambdaQueryWrapper.eq(role != null, Menu::getRole, role);
            //查询当前菜单下的子菜单
            lambdaQueryWrapper.eq(Menu::getParent, menu.getId());
            List<Menu> list = this.list(lambdaQueryWrapper);
            menu.setChildren(list);
        }
        return menus;
    }
}
