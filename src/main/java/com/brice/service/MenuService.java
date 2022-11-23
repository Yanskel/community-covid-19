package com.brice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.brice.entity.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {
    List<Menu> getAll(Integer role);
}
