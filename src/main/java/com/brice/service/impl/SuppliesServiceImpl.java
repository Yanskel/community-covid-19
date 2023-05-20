package com.brice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.Supplies;
import com.brice.mapper.SuppliesMapper;
import com.brice.service.SuppliesService;

/**
 * 物资Service实现类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Service
public class SuppliesServiceImpl extends ServiceImpl<SuppliesMapper, Supplies> implements SuppliesService {}
