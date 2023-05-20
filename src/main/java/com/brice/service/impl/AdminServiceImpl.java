package com.brice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.Admin;
import com.brice.mapper.AdminMapper;
import com.brice.service.AdminService;

/**
 * 管理员Service实现类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {}
