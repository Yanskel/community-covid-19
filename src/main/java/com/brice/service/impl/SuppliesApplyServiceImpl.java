package com.brice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.SuppliesApply;
import com.brice.mapper.SuppliesApplyMapper;
import com.brice.service.SuppliesApplyService;

/**
 * 物资申请Service实现类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Service
public class SuppliesApplyServiceImpl extends ServiceImpl<SuppliesApplyMapper, SuppliesApply>
    implements SuppliesApplyService {}
