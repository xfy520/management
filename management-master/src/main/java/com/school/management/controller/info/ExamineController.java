package com.school.management.controller.info;

import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.common.utils.IDUtils;
import com.school.management.domain.Exam;
import com.school.management.domain.Examine;
import com.school.management.domain.Subject;
import com.school.management.service.info.IExamService;
import com.school.management.service.info.IExamineService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/info/examine")
public class ExamineController extends BaseController {

    private String prefix = "info/examine";

    @Resource
    IExamService examService;

    @Resource
    IExamineService examineService;

    @GetMapping()
    public String examine(HttpServletRequest request, ModelMap map)
    {
        Exam exam = new Exam();
        HttpSession session = request.getSession();
        exam.setCreateBy((Long) session.getAttribute("uuid"));
        List<Exam> list = examService.selectExamList(exam);
        map.put("exams", list);
        return prefix + "/examine";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Examine examine)
    {
        try {
            examine.setExamineId(IDUtils.getId());
            if (examService.isExam(examine.getExamId()) > 0){
                examineService.insertExamines(examine);
                return success();
            }
            return error("添加考生失败!!!");
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Examine examine)
    {
        startPage();
        List<Examine> list = examineService.selectExamineList(examine);
        return getDataTable(null);
    }
}
