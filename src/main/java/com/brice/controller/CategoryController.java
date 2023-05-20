package com.brice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brice.common.R;
import com.brice.entity.Category;
import com.brice.service.CategoryService;

/**
 * 物资分类Controller
 *
 * @author Brice
 * @date 2023/05/20
 */
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 获取所有物资种类
     *
     * @return 物资种类数据
     */
    @GetMapping
    public R<List<Category>> getAll() {
        List<Category> list = categoryService.list();
        return R.success(list);
    }
}
