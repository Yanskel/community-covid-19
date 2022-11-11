package com.brice.controller;

import com.brice.common.R;
import com.brice.entity.Category;
import com.brice.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public R<List<Category>> getAll(){
        List<Category> list = categoryService.list();
        return R.success(list);
    }
}
