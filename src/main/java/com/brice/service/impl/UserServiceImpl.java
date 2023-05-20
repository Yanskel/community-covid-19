package com.brice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.User;
import com.brice.mapper.UserMapper;
import com.brice.service.UserService;

/**
 * 用户Service实现类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {}
