package com.school.management.mapper;

import java.util.List;

import com.school.management.domain.Dept;
import com.school.management.domain.User;

/**
 * 部门管理 数据层
 *
 */
public interface DeptMapper
{
    /**
     * 查询部门管理数据
     *
     * @param user 部门信息
     * @return 部门信息集合
     */
    List<Dept> selectDeptList(User user);
}
