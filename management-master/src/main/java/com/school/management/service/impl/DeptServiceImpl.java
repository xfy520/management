package com.school.management.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.school.management.common.constant.UserConstants;
import com.school.management.common.core.domain.Ztree;
import com.school.management.common.utils.StringUtils;
import com.school.management.domain.Dept;
import com.school.management.domain.User;
import com.school.management.mapper.DeptMapper;
import com.school.management.service.IDeptService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 部门管理 服务实现
 *
 * @author ruoyi
 */
@Service
public class DeptServiceImpl implements IDeptService
{
    @Resource
    private DeptMapper deptMapper;

    /**
     * 查询部门管理树
     *
     * @param user 部门信息
     * @return 所有部门信息
     */
    @Override
    public List<Ztree> selectDeptTree(User user)
    {
        List<Dept> deptList = deptMapper.selectDeptList(user);
        List<Ztree> ztrees = initZtree(deptList);
        return ztrees;
    }

    /**
     * 对象转树
     *
     * @param deptList 列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<Dept> deptList)
    {

        List<Ztree> ztrees = new ArrayList<Ztree>();
        for (Dept dept : deptList)
        {
            Ztree ztree = new Ztree();
            ztree.setId(dept.getDeptId());
            ztree.setType(dept.getType());
            ztree.setpId(dept.getParentId());
            ztree.setName(dept.getDeptName());
            ztree.setTitle(dept.getDeptName());
            ztrees.add(ztree);
        }
        return ztrees;
    }
}
