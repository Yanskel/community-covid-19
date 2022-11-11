package com.brice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.Supplies;
import com.brice.mapper.SuppliesMapper;
import com.brice.service.SuppliesService;
import org.springframework.stereotype.Service;

@Service
public class SuppliesServiceImpl extends ServiceImpl<SuppliesMapper, Supplies> implements SuppliesService {
}
