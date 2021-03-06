package com.school.management.controller.info;

import com.school.management.common.annotation.Annotation;
import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.domain.Grade;
import com.school.management.domain.Subject;
import com.school.management.domain.Teacher;
import com.school.management.service.info.IGradeService;
import com.school.management.service.info.ISubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/info/grade")
public class GradeController extends BaseController {

    @Resource
    private IGradeService gradeService;

    @Resource
    private ISubjectService subjectService;

    private String prefix = "info/grade";

    @GetMapping()
    public String grade()
    {
        return prefix + "/grade";
    }

    @GetMapping("/subject")
    public String subject(ModelMap map)
    {
        map.put("subject", subjectService.selectSubjectList(new Subject()));
        return prefix + "/subject";
    }

    @PostMapping("/subject")
    @ResponseBody
    public AjaxResult updateSubject(Grade grade)
    {
        try {
            gradeService.updateSubject(grade);
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    @Annotation(operation = "年级查询")
    public TableDataInfo list(String subjectId)
    {
        startPage();
        List<Grade> list = gradeService.selectGradeList(subjectId);
        return getDataTable(list);
    }
}
