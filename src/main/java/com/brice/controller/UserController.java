package com.brice.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.brice.common.R;
import com.brice.dto.UserDto;
import com.brice.entity.ApartmentComplex;
import com.brice.entity.User;
import com.brice.service.ApartmentComplexService;
import com.brice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private ApartmentComplexService apartmentComplexService;

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
        if (one == null) {
            return R.success("");
        } else {
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
    public R<String> update(@RequestBody User user) {
        userService.updateById(user);
        return R.success("更新成功");
    }

    /**
     * 用户数据分页查询
     *
     * @param page     当前页码
     * @param pageSize 每一页显示的条数
     * @param name     条件（姓名）
     * @return 处理过后的用户数据
     */
    @GetMapping("/page")
    public R<Page<UserDto>> getAll(int page, int pageSize, String name) {
        //添加分页构造器
        Page<User> pageInfo = new Page<>(page, pageSize);
        //条件构造器
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name), User::getName, name);
        //查询出对应页数的数据
        userService.page(pageInfo, queryWrapper);
        //list对象拷贝
        Page<UserDto> userDtoPage = new Page<>();
        //排除数据库内容
        BeanUtils.copyProperties(pageInfo, userDtoPage, "records");

        List<User> records = pageInfo.getRecords();
        List<UserDto> list = records.stream().map(user -> {
            //对象拷贝
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user, userDto);
            //根据居民自身的小区id查询小区名字
            ApartmentComplex apartmentComplex = apartmentComplexService.getById(user.getAcId());
            if (apartmentComplex != null) {
                userDto.setAcName(apartmentComplex.getAcName());
            }
            return userDto;
        }).collect(Collectors.toList());
        //重新写入新数据
        userDtoPage.setRecords(list);
        return R.success(userDtoPage);
    }

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return 成功与否
     */
    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable Long id) {
        userService.removeById(id);
        return R.success("删除成功");
    }
}
