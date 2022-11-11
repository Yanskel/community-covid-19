package com.brice.controller;

import com.brice.common.R;
import com.brice.entity.ApartmentComplex;
import com.brice.service.ApartmentComplexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public R<List<ApartmentComplex>> getAll(){
        List<ApartmentComplex> list = apartmentComplexService.list();
        return R.success(list);
    }
}
