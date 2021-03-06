package com.school.management.controller.info;

import com.school.management.common.config.Global;
import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.utils.file.FileUploadUtils;
import com.school.management.service.info.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/avatar")
    public String avatar()
    {
        return prefix + "/avatar";
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

    /**
     * 验证用户名是否存在
     * @param loginName
     * @return
     */
    @PostMapping("/checkLoginNameUnique")
    @ResponseBody
    public String checkLoginNameUnique(String loginName)
    {
        return userService.checkLoginNameUnique(loginName);
    }

    /**
     * 验证身份证号否存在
     * @param idNumber
     * @return
     */
    @PostMapping("/checkIdNumberUnique")
    @ResponseBody
    public String checkIdNumberUnique(String idNumber)
    {
        return userService.checkIdNumberUnique(idNumber);
    }

}
