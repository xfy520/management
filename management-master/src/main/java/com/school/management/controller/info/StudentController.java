package com.school.management.controller.info;


import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.common.utils.poi.ExcelUtil;
import com.school.management.domain.Student;
import com.school.management.service.info.IStudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/info/student")
public class StudentController extends BaseController {

    private String prefix = "info/student";

    @Resource
    private IStudentService studentService;

    @GetMapping()
    public String user()
    {
        return prefix + "/student";
    }

    @GetMapping("/add")
    public String add(){
        return prefix + "/add";
    }

    @GetMapping("/edit/{userId}")
    public String edit(@PathVariable("userId")Long userId, ModelMap map){
        Student student = new Student();
        student.setUserId(userId);
        map.put("student", studentService.selectStudentById(student));
        return prefix + "/edit";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@ModelAttribute("student") Student student,@ModelAttribute("isSchoolRoll") boolean isSchoolRoll, HttpServletRequest request)
    {
        try {
            HttpSession session = request.getSession();
            student.setCreateBy((Long) session.getAttribute("uuid"));
            studentService.insertStudent(student, isSchoolRoll);
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
    public AjaxResult update(Student student, HttpServletRequest request)
    {
        try {
            HttpSession session = request.getSession();
            student.setUpdateBy((Long) session.getAttribute("uuid"));
            return toAjax(studentService.updateStudent(student));
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@Validated Student student)
    {
        startPage();
        List<Student> list = studentService.selectStudentList(student);
        return getDataTable(list);
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        return util.importTemplateExcel("用户数据");
    }

    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, boolean updateSupport) throws Exception
    {
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        List<Student> studentList = util.importExcel(file.getInputStream());
        String message = studentService.importStudent(studentList, updateSupport, "admin");
        return AjaxResult.success(message);
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(@Validated Student student)
    {
        List<Student> list = studentService.selectStudentList(student);
        ExcelUtil<Student> util = new ExcelUtil<Student>(Student.class);
        return util.exportExcel(list, "学生数据");
    }
}
