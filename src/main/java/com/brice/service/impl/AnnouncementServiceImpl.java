package com.brice.service.impl;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.brice.entity.Announcement;
import com.brice.mapper.AnnouncementMapper;
import com.brice.service.AnnouncementService;

/**
 * 公告Service实现类
 *
 * @author Brice
 * @date 2023/05/20
 */
@Service
public class AnnouncementServiceImpl extends ServiceImpl<AnnouncementMapper, Announcement>
    implements AnnouncementService {}
