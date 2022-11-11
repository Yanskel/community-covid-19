package com.brice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.brice.common.R;
import com.brice.entity.User;
import com.brice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 用户登录
     *
     * @param user    登录信息
     * @param request HttpServletRequest
     * @return 返回用户对象
     */
    @PostMapping("/login")
    public R<User> login(@RequestBody User user, HttpServletRequest request) {
        //密码进行MD5
        String password = user.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        //创建构造器
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        //根据用户名查找数据库
        queryWrapper.eq(User::getUsername, user.getUsername());
        User userOne = userService.getOne(queryWrapper);
        //没有该用户
        if (userOne == null) {
            return R.error("该用户名不存在");
        }
        //密码错误
        if (!userOne.getPassword().equals(password)) {
            return R.error("密码错误");
        }
        //该账户已禁用
        if (userOne.getStatus() == 0) {
            return R.error("该账户已禁用，请联系管理员");
        }
        request.getSession().setAttribute("user", userOne.getId());
        return R.success(userOne);
    }

    /**
     * 用户注册
     *
     * @param user 注册信息
     * @return 成功与否
     */
    @PostMapping("/register")
    public R<String> register(@RequestBody User user) {
        user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
        boolean flag = userService.save(user);
        return flag ? R.success("注册成功") : R.error("注册失败");
    }

    /**
     * 用户名查重
     *
     * @param username 用户名
     * @return 查重结果
     */
    @GetMapping("/check")
    public R<String> getByUsername(String username) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User one = userService.getOne(queryWrapper);
        if (one == null){
            return R.success("");
        }else {
            return R.error("该用户名已存在");
        }
    }

    /**
     * 更新用户数据
     *
     * @param user 用户对象
     * @return 成功与否
     */
    @PutMapping
    public R<String> update(@RequestBody User user){
        userService.updateById(user);
        return R.success("success");
    }
}
