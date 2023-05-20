package com.brice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.HealthInfo;
import com.brice.mapper.HealthInfoMapper;
import com.brice.service.HealthInfoService;

/**
 * 健康信息Service实现类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Service
public class HealthInfoServiceImpl extends ServiceImpl<HealthInfoMapper, HealthInfo> implements HealthInfoService {}
