package com.school.management.controller;

import com.school.management.common.core.domain.Ztree;
import com.school.management.domain.User;
import com.school.management.service.IDeptService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/info/dept")
public class DeptController {

    @Resource
    private IDeptService deptService;

    /**
     * 加载联动数据列表树
     */
    @PostMapping("/treeData")
    @ResponseBody
    public List<Ztree> treeData()
    {
        List<Ztree> ztrees = deptService.selectDeptTree(new User());
        return ztrees;
    }
}
