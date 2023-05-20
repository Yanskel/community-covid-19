package com.brice.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brice.entity.Announcement;

/**
 * 公告Mapper
 *
 * @author Brice
 * @date 2023/05/20
 */
@Mapper
public interface AnnouncementMapper extends BaseMapper<Announcement> {}
