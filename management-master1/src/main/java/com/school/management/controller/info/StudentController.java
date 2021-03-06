package com.school.management.controller.info;


import com.school.management.common.annotation.Annotation;
import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.common.utils.poi.ExcelUtil;
import com.school.management.domain.Student;
import com.school.management.service.info.IGradeService;
import com.school.management.service.info.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/info/student")
public class StudentController extends BaseController {

    private String prefix = "info/student";

    @Resource
    private IStudentService studentService;

    @Resource
    private IGradeService gradeService;

    @GetMapping()
    public String user(ModelMap map)
    {
        map.put("grade", gradeService.selectGradeList(null));
        return prefix + "/student";
    }

    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @GetMapping("/edit/{userId}")
    @Annotation(operation = "修改用户")
    public String edit(@PathVariable("userId")String userId, ModelMap map){
        Student student = new Student();
        student.setId(userId);
        map.put("student", studentService.selectStudentById(student));
        return prefix + "/edit";
    }

    @PostMapping("/add")
    @ResponseBody
    @Annotation(operation = "新增用户")
    public AjaxResult addSave(Student student)
    {
        try {
            studentService.insertStudent(student);
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
            return toAjax(studentService.deleteStudentByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(Student student)
    {
        try {
            return toAjax(studentService.updateStudent(student));
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Student student)
    {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
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
        return studentService.checkIdNumberUnique(idNumber);
    }
}
