package com.school.management.controller;

import com.google.code.kaptcha.Constants;
import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.utils.ServletUtils;
import com.school.management.common.utils.StringUtils;
import com.school.management.domain.Login;
import com.school.management.domain.User;
import com.school.management.service.ILoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class loginController extends BaseController {

    @Resource
    private ILoginService loginService;

    @GetMapping("/login")
    public String login(HttpServletRequest request, HttpServletResponse response)
    {
        // 如果是Ajax请求，返回Json字符串。
        if (ServletUtils.isAjaxRequest(request))
        {
            return ServletUtils.renderString(response, "{\"code\":\"1\",\"msg\":\"未登录或登录超时。请重新登录\"}");
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session=request.getSession();
        session.removeAttribute("uuid");
        session.removeAttribute("perms");
        session.removeAttribute("gradeId");
        session.removeAttribute("avatar");
        session.removeAttribute("loginName");
        session.removeAttribute("userName");
        session.invalidate();
        return redirect("login");
    }

    @PostMapping("/login")
    @ResponseBody
    public AjaxResult ajaxLogin(HttpServletRequest request)
    {
        String msg = "登录成功!!!";
        try
        {
            HttpSession session = request.getSession();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String validateCode = request.getParameter("validateCode");
            String sessionCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
            if(username == null || StringUtils.isEmpty(username)){
                msg = "用户名为空";
            }else if(password == null || StringUtils.isEmpty(password)){
                msg = "密码为空";
            }else if(validateCode == null || StringUtils.isEmpty(validateCode)){
                msg = "验证码为空";
            }else if(sessionCode == null || StringUtils.isEmpty(sessionCode)){
                msg = "验证码错误";
            }else if(!validateCode.equalsIgnoreCase(sessionCode)){
                msg = "验证码错误";
            }else{
                Login login = loginService.loginAuth(username, password);
                if(login == null){
                    msg = "用户或密码错误";
                }else{
                    session.setAttribute("perms", login.getPerms());
                    session.setAttribute("uuid", login.getUserId());
                    session.setAttribute("gradeId", login.getGradeId());
                    session.setAttribute("avatar",login.getAvatar());
                    session.setAttribute("loginName",login.getLoginName());
                    session.setAttribute("userName",login.getUserName());
                    return success();
                }
            }
        }
        catch (Exception e)
        {
            msg = "系统异常错误";
            if (StringUtils.isNotEmpty(e.getMessage()))
            {
                msg = e.getMessage();
            }
            return error(msg);
        }
        return error(msg);
    }
}
