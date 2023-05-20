package com.brice.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.brice.entity.Menu;

/**
 * 菜单Mapper
 *
 * @author Brice
 * @date 2023/05/20
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {}
