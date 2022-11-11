package com.brice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.HealthInfo;
import com.brice.mapper.HealthInfoMapper;
import com.brice.service.HealthInfoService;
import org.springframework.stereotype.Service;

@Service
public class HealthInfoServiceImpl extends ServiceImpl<HealthInfoMapper, HealthInfo> implements HealthInfoService {
}
