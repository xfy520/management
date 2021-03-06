package com.school.management.controller.info;

import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.domain.Grade;
import com.school.management.domain.Student;
import com.school.management.domain.Teacher;
import com.school.management.domain.User;
import com.school.management.service.info.IGradeService;
import com.school.management.service.info.ITeacherService;
import com.school.management.service.info.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/info/grade")
public class GradeController extends BaseController {

    @Resource
    private IGradeService gradeService;

    private String prefix = "info/grade";

    @GetMapping()
    public String grade()
    {
        return prefix + "/grade";
    }

    @GetMapping("/leader")
    public String leader(){
        return prefix + "/leader";
    }

    @PostMapping("/leader")
    @ResponseBody
    public AjaxResult leader(Grade grade, HttpServletRequest request)
    {
        try {
            HttpSession session = request.getSession();
            grade.setUpdateBy((Long) session.getAttribute("uuid"));
            gradeService.updateLeader(grade);
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        List<Grade> list = gradeService.selectGradeList();
        return getDataTable(list);
    }
}
