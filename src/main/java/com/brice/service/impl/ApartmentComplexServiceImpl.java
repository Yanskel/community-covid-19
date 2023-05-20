package com.brice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.ApartmentComplex;
import com.brice.mapper.ApartmentComplexMapper;
import com.brice.service.ApartmentComplexService;

/**
 * 小区Service实现类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Service
public class ApartmentComplexServiceImpl extends ServiceImpl<ApartmentComplexMapper, ApartmentComplex>
    implements ApartmentComplexService {}
