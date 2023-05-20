package com.brice.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brice.entity.Admin;

/**
 * 管理员Mapper
 *
 * @author Brice
 * @date 2023/05/20
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {}
