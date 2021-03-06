package com.school.management.controller.info;

import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.common.utils.IDUtils;
import com.school.management.domain.*;
import com.school.management.service.info.IExamService;
import com.school.management.service.info.IGradeService;
import com.school.management.service.info.ISubjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/info/exam")
public class ExamController extends BaseController {

    private String prefix = "info/exam";

    @Resource
    private ISubjectService subjectService;

    @Resource
    private IGradeService gradeService;

    @Resource
    IExamService examService;

    @GetMapping()
    public String exam(ModelMap map)
    {
        map.put("subject", subjectService.selectSubjectList(new Subject()));
        return prefix + "/exam";
    }

    @GetMapping("/add")
    public String add(ModelMap map, HttpServletRequest request){
        subjectClass(map, request);
        return prefix + "/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Exam exam, HttpServletRequest request)
    {
        try {
            HttpSession session = request.getSession();
            exam.setExamId(IDUtils.getId());
            exam.setCreateBy((String) session.getAttribute("uuid"));

            Calendar examCalendar = Calendar.getInstance();
            examCalendar.setTime(exam.getStartDate());
            Long yearLong = new Long((long)examCalendar.get(Calendar.YEAR));
            Long monthLong = new Long((long)(examCalendar.get(Calendar.MONTH) + 1));
            Long dateLong = new Long((long)examCalendar.get(Calendar.DATE));
            Calendar nowCalendar = Calendar.getInstance();
            Long hourLong = new Long((long)nowCalendar.get(Calendar.HOUR_OF_DAY));
            Long minuteLong = new Long((long)nowCalendar.get(Calendar.MINUTE));
            Long secondLong = new Long((long)nowCalendar.get(Calendar.SECOND));
            Long examNumber = yearLong * 1000000000000L + monthLong * 10000000000L + dateLong * 100000000L +
                    Long.valueOf(exam.getExamType()) * 1000000L + hourLong * 3600L + minuteLong * 60 + secondLong;

            exam.setExamNumber(examNumber);

            examService.insertExam(exam);
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
            return toAjax(examService.deleteExamByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    @GetMapping("/edit/{examId}")
    public String edit(@PathVariable("examId")String examId, HttpServletRequest request, ModelMap map){
        subjectClass(map, request);
        map.put("exam", examService.selectExamById(examId));
        return prefix + "/edit";
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(Exam exam)
    {
        try {
            return toAjax(examService.updateExam(exam));
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Exam exam, HttpServletRequest request)
    {
        startPage();
        HttpSession session = request.getSession();
        exam.setCreateBy((String) session.getAttribute("uuid"));
        List<Exam> list = examService.selectExamList(exam);
        return getDataTable(list);
    }

    private void subjectClass(ModelMap map, HttpServletRequest req) {
        HttpSession session = req.getSession();
        Teacher teacher = new Teacher();
        Object permsObj = session.getAttribute("perms");
        Object userIdObj = session.getAttribute("uuid");
        if (permsObj != null && permsObj != "") {
            teacher.setPerms((int) permsObj);
        }
        if(userIdObj != null && userIdObj != ""){
            teacher.setId((String) userIdObj);
        }
        map.put("subject", examService.selectExamSubjectList(teacher));
        if(permsObj != null && permsObj != "" && (int)permsObj == 1){
            map.put("grade", gradeService.selectGradeList(null));
        }else if(permsObj != null && permsObj != ""){
            map.put("class", examService.selectExamClassList(teacher));
        }
    }


}
