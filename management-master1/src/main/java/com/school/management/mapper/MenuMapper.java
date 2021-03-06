package com.school.management.mapper;

import com.school.management.domain.Menu;

import java.util.List;

/**
 * 菜单表 数据层
 *
 */
public interface MenuMapper
{
    /**
     * 根据用户ID查询菜单
     *
     * @param Id 用户ID
     * @return 菜单列表
     */
    List<Menu> selectMenusByUserId(String Id);
}
