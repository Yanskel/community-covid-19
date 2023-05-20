package com.brice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.util.ObjectUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.brice.common.R;
import com.brice.entity.Admin;
import com.brice.entity.Menu;
import com.brice.service.AdminService;
import com.brice.service.MenuService;

import cn.hutool.core.util.StrUtil;

/**
 * 管理员Controller
 *
 * @author Brice
 * @date 2023/05/20
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private MenuService menuService;

    /**
     * 管理员登录
     *
     * @param admin 用户对象
     * @param request session
     * @return 正确的用户对象
     */
    @PostMapping("/login")
    public R<Map<String, Object>> login(@RequestBody Admin admin, HttpServletRequest request) {
        String username = admin.getUsername();
        String password = admin.getPassword();
        if (StrUtil.isBlank(username)) {
            return R.error("请输入用户名");
        }
        if (StrUtil.isBlank(password)) {
            return R.error("请输入密码");
        }
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername, username);
        Admin adminOne = adminService.getOne(queryWrapper);
        if (ObjectUtil.isNull(adminOne)) {
            return R.error("该用户名不存在");
        }
        if (!adminOne.getPassword().equals(password)) {
            return R.error("密码错误");
        }
        request.getSession().setAttribute("user", adminOne);
        List<Menu> menus = menuService.getAll(null);
        Map<String, Object> map = new HashMap<>();
        map.put("admin", adminOne);
        map.put("menu", menus);
        return R.success(map);
    }
}
