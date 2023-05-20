package com.brice.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.brice.entity.Menu;

/**
 * 菜单Service
 *
 * @author Brice
 * @date 2023/05/20
 */
public interface MenuService extends IService<Menu> {
    /**
     * 按层级查询所有菜单
     *
     * @param role 角色
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> getAll(Integer role);
}
