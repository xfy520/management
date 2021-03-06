package com.school.management.controller.info;

import com.school.management.common.config.Global;
import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.utils.file.FileUploadUtils;
import com.school.management.service.info.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController  extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private String prefix = "info";


    @Resource
    private IUserService userService;

    @GetMapping("")
    public String user(ModelMap map, HttpServletRequest req){
        HttpSession session = req.getSession();
        Object uuid = session.getAttribute("uuid");
        Object permsObj = session.getAttribute("perms");
        if(permsObj != null && permsObj !=""){
            if((int) permsObj == 3){
                map.put("user", userService.selectStudent((String)uuid));
            }else if((int)permsObj >=0 && (int)permsObj <= 2){
                map.put("user", userService.selectUser((String)uuid));
            }else{
                return "/login";
            }
        }else{
            return "/login";
        }
        return prefix + "/profile";
    }

    @GetMapping("/avatar")
    public String avatar()
    {
        return prefix + "/avatar";
    }

    @PostMapping("/resetPwd")
    @ResponseBody
    public AjaxResult resetPwd(String oldPassword, String newPassword, HttpServletRequest req){
        HttpSession session = req.getSession();
        Object uuid = session.getAttribute("uuid");
        try {
            if (userService.resetPwd(oldPassword, newPassword, (String) uuid) == 1){
                return success();
            }else{
                return error("修改密码失败");
            }
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/checkPassword")
    @ResponseBody
    public String checkPassword(String password, HttpServletRequest req){
        HttpSession session = req.getSession();
        Object uuid = session.getAttribute("uuid");
        return userService.checkPassword((String) uuid, password);
    }

    @PostMapping("/updateAvatar")
    @ResponseBody
    public AjaxResult updateAvatar(@RequestParam("avatarfile") MultipartFile file, HttpServletRequest request)
    {
        try
        {
            if (!file.isEmpty())
            {
                String avatar = FileUploadUtils.upload(Global.getAvatarPath(), file);
                HttpSession session = request.getSession();
                session.setAttribute("avatar",avatar);
                return success();
            }
            return error();
        }
        catch (Exception e)
        {
            log.error("修改头像失败！", e);
            return error(e.getMessage());
        }
    }

}
