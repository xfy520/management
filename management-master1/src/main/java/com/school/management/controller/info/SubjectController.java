package com.school.management.controller.info;

import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.domain.Student;
import com.school.management.domain.Subject;
import com.school.management.service.info.ISubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/info/subject")
public class SubjectController  extends BaseController {

    private static final Logger log = LoggerFactory.getLogger(SubjectController.class);

    private String prefix = "info/subject";

    @Resource
    private ISubjectService subjectService;

    @GetMapping()
    public String user()
    {
        return prefix + "/subject";
    }

    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Subject subject)
    {
        try {
            subjectService.insertSubject(subject);
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
            return toAjax(subjectService.deleteSubjectByIds(ids));
        }
        catch (Exception e)
        {
            return error(e.getMessage());
        }
    }

    @GetMapping("/edit/{subjectId}")
    public String edit(@PathVariable("subjectId")String subjectId, ModelMap map){
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        map.put("subject", subjectService.selectSubjectById(subject));
        return prefix + "/edit";
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(Subject subject)
    {
        try {
            return toAjax(subjectService.updateSubject(subject));
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Subject subject)
    {
        startPage();
        List<Subject> list = subjectService.selectSubjectList(subject);
        return getDataTable(list);
    }

    @PostMapping("/changeElective")
    @ResponseBody
    public AjaxResult changeElective(Subject subject)
    {
        return toAjax(subjectService.changeElective(subject));
    }

    /**
     * 验证学科是否存在
     * @param subjectName
     * @return
     */
    @PostMapping("/checkSubjectNameUnique")
    @ResponseBody
    public String checkSubjectNameUnique(String subjectName)
    {
        return subjectService.checkSubjectNameUnique(subjectName);
    }

}
