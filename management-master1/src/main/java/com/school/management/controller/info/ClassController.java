package com.school.management.controller.info;

import com.school.management.common.annotation.Annotation;
import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.domain.Class;
import com.school.management.domain.Grade;
import com.school.management.domain.Student;
import com.school.management.service.info.IClassService;
import com.school.management.service.info.IGradeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/info/class")
public class ClassController extends BaseController {

    private String prefix = "info/class";

    @Resource
    private IGradeService gradeService;

    @Resource
    private IClassService classService;

    @GetMapping()
    public String shift(ModelMap map)
    {
        map.put("grade", gradeService.selectGradeList(null));
        return prefix + "/class";
    }

    @GetMapping("/leader")
    public String leader(){
        return prefix + "/leader";
    }

    @PostMapping("/leader")
    @ResponseBody
    public AjaxResult leader(Class shift)
    {
        try {
            classService.updateLeader(shift);
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(String gradeId)
    {
        try {
            classService.insertClass(gradeId);
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/remove")
    @ResponseBody
    @Annotation(operation = "班级删除")
    public AjaxResult remove(String classId)
    {
        try {
            classService.deleteClass(classId);
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    @Annotation(operation = "班级查询")
    public TableDataInfo list(Class shift)
    {
        startPage();
        List<Class> list = classService.selectClassList(shift);
        return getDataTable(list);
    }

    @PostMapping("/search")
    @ResponseBody
    public TableDataInfo search(String teacherId, String gradeId, String subjectId)
    {
        startPage();
        List<Class> list = classService.searchClassList(teacherId, gradeId, subjectId);
        return getDataTable(list);
    }
}
