package com.brice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.Category;
import com.brice.mapper.CategoryMapper;
import com.brice.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
