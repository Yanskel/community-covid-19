package com.brice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brice.common.R;
import com.brice.entity.ApartmentComplex;
import com.brice.service.ApartmentComplexService;

/**
 * 小区Controller
 *
 * @author Brice
 * @date 2023/05/20
 */
@RestController
@RequestMapping("/api/apartmentComplex")
public class ApartmentComplexController {
    @Autowired
    private ApartmentComplexService apartmentComplexService;

    /**
     * 查询所有小区
     *
     * @return 小区集合
     */
    @GetMapping
    public R<List<ApartmentComplex>> getAll() {
        List<ApartmentComplex> list = apartmentComplexService.list();
        return R.success(list);
    }
}
