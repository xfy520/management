package com.school.management.component;

import com.school.management.common.annotation.Annotation;
import com.school.management.domain.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.omg.CORBA.UserException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * Created by limi on 2017/10/13.
 */
@Aspect
@Component
public class LogAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 环绕通知：
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     */
    @Around(value = "@annotation(annotation)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint, Annotation annotation) throws Throwable {
        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        HttpSession session = request.getSession();
        Object userNameObj = session.getAttribute("username");
        String userName = userNameObj != null && userNameObj != "" ? (String) userNameObj : "";
        Object userIdObj = session.getAttribute("uuid");
        String userId = userIdObj != null && userIdObj != "" ? (String) userIdObj : "";
        Object permsObj = session.getAttribute("perms");
        int perms = permsObj != null && permsObj !="" ? (int) permsObj : 0;
        String url = request.getRequestURL().toString();
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();

        Object[] args = null;
        Object returnValue = null;
        try {
            args = joinPoint.getArgs();
            returnValue = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Log log = new Log(userId, userName, perms, url, classMethod, args, returnValue, annotation.operation());
        System.out.println("-----------------------------------------------------------" + log.toString());
        return returnValue;
    }

}
