package com.brice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.Category;
import com.brice.mapper.CategoryMapper;
import com.brice.service.CategoryService;

/**
 * 物资分类Service实现类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {}
