package com.school.management.controller.info;

import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.common.utils.IDUtils;
import com.school.management.domain.*;
import com.school.management.domain.Class;
import com.school.management.service.info.IClassService;
import com.school.management.service.info.IExamService;
import com.school.management.service.info.IExamineService;
import com.school.management.service.info.ISubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/info/examine")
public class ExamineController extends BaseController {

    private String prefix = "info/exam";

    @Resource
    IExamService examService;

    @Resource
    IExamineService examineService;

    @Resource
    private IClassService classService;

    @Resource
    private ISubjectService subjectService;


    @GetMapping("/show/{examId}")
    public String examine(@PathVariable("examId")String examId, ModelMap map)
    {
        map.put("class", classService.selectExamineClassList(examId));
        map.put("subject", subjectService.selectExamineSubjectList(examId));
        map.put("examId", examId);
        return prefix + "/examine/examine";
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/examine/add";
    }

    @PostMapping("/search")
    @ResponseBody
    public TableDataInfo search(Long userId, String classId, String examId, String subjectId)
    {
        startPage();
        try {
            return getDataTable(examineService.searchStudentList(userId, classId, examId, subjectId));
        }catch (Exception e){
            return getDataTable(new ArrayList<>());
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Examine examine, String subjectIds)
    {
        try {
            examine.setExamineId(IDUtils.getId());
            if (examService.isExam(examine.getExamId()) > 0){
                examineService.insertExamines(examine, subjectIds);
                return success();
            }
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String examId, String classId, String subjectId, Long userId)
    {
        startPage();
        List<Student> list = examineService.selectExamineList(examId, classId, subjectId, userId);
        return getDataTable(list);
    }

    @PostMapping("/insert")
    @ResponseBody
    public AjaxResult insertExamineById(Examine examine){
        try {
            examineService.insertExamineById(examine);
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }
}
