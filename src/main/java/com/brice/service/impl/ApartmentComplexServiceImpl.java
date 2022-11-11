package com.brice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.ApartmentComplex;
import com.brice.mapper.ApartmentComplexMapper;
import com.brice.service.ApartmentComplexService;
import org.springframework.stereotype.Service;

@Service
public class ApartmentComplexServiceImpl extends ServiceImpl<ApartmentComplexMapper, ApartmentComplex> implements ApartmentComplexService {
}
