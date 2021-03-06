package com.school.management.controller;

import com.school.management.domain.Menu;
import com.school.management.domain.User;
import com.school.management.service.IMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class indexController {

    @Resource
    private IMenuService menuService;


    // 系统首页
    @GetMapping(value = {"/index", "/index.html", "/"})
    public String index(ModelMap map)
    {
        User user = new User();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUser(user);
        map.put("menus", menus);
        return "index";
    }
}
