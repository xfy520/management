package com.school.management.service;

import com.school.management.common.core.domain.Ztree;
import com.school.management.domain.User;

import java.util.List;

/**
 * 服务层
 *
 */
public interface IDeptService
{
    /**
     * 查询部门管理树
     *
     * @param user 部门信息
     * @return 所有部门信息
     */
    List<Ztree> selectDeptTree(User user);
}
