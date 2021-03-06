package com.school.management.controller.info;


import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.common.utils.poi.ExcelUtil;
import com.school.management.domain.Class;
import com.school.management.domain.Student;
import com.school.management.domain.Subject;
import com.school.management.domain.Teacher;
import com.school.management.service.IIndexService;
import com.school.management.service.info.IStudentService;
import com.school.management.service.info.ISubjectService;
import com.school.management.service.info.ITeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/info/teacher")
public class TeacherController extends BaseController {

    private String prefix = "info/teacher";

    @Resource
    private ISubjectService subjectService;

    @Resource
    private IStudentService studentService;

    @Resource
    private ITeacherService teacherService;

    @GetMapping()
    public String teacher(ModelMap map)
    {
        map.put("subject", subjectService.selectSubjectList(new Subject()));
        return prefix + "/teacher";
    }

    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId") String userId, ModelMap map){
        Teacher teacher = new Teacher();
        teacher.setId(userId);
        map.put("teacher", teacherService.selectTeacherById(teacher));
        return prefix + "/edit";
    }

    @GetMapping("/edit/class")
    public String editClass(){
        return prefix + "/class";
    }

    @PostMapping("/class")
    @ResponseBody
    public AjaxResult updateClass(Teacher teacher)
    {
        try {
            teacherService.updateTeacherClass(teacher);
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/class/search")
    @ResponseBody
    public TableDataInfo classSearch(Teacher teacher)
    {
        startPage();
        List<Class> list = teacherService.classSearch(teacher);
        return getDataTable(list);
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Teacher teacher)
    {
        try {
            teacherService.insertTeacher(teacher);
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        try
        {
            return toAjax(teacherService.deleteTeacherByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(Teacher teacher)
    {
        try {
            return toAjax(teacherService.updateTeacher(teacher));
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Teacher teacher)
    {
        startPage();
        List<Teacher> list = teacherService.selectTeacherList(teacher);
        return getDataTable(list);
    }

    @PostMapping("/search")
    @ResponseBody
    public List<Teacher> search(String perName)
    {
        try {
            Teacher teacher = new Teacher();
            if(perName != null && isPhone(perName)){
                teacher.setUserId(Long.valueOf(perName));
            }else{
                teacher.setUserName(perName);
            }
            return teacherService.searchTeacherList(teacher);
        }catch (Exception e){
            return new ArrayList<>();
        }
    }

    /**
     * 验证账号是否存在
     * @param userId
     * @return
     */
    @PostMapping("/checkUserIdUnique")
    @ResponseBody
    public String checkUserIdUnique(Long userId)
    {
        return teacherService.checkUserIdUnique(userId);
    }

    public static boolean isPhone(String phone) {
        String regex = "^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$";
        if (phone.length() != 11) {
            return false;
        } else {
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(phone);
            boolean isMatch = m.matches();
            return isMatch;
        }
    }
}
