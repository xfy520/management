package com.school.management.service;


import com.school.management.domain.Menu;
import com.school.management.domain.User;

import java.util.List;

/**
 * 菜单 业务层
 *
 */
public interface IMenuService
{
    List<Menu> selectMenusByUser(User user);
}
