package com.school.management.controller.info;

import com.school.management.common.annotation.Annotation;
import com.school.management.common.core.controller.BaseController;
import com.school.management.common.core.domain.AjaxResult;
import com.school.management.common.core.page.TableDataInfo;
import com.school.management.common.utils.poi.ExcelUtil;
import com.school.management.domain.*;
import com.school.management.domain.Class;
import com.school.management.service.info.IScoreService;
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

@Controller
@RequestMapping("/info/score")
public class ScoreController extends BaseController {

    private String prefix = "info/score";

    @Resource
    private IScoreService scoreService;

    @GetMapping()
    public String score(ModelMap map, HttpServletRequest req)
    {
        HttpSession session = req.getSession();
        Object uuid = session.getAttribute("uuid");
        Object permsObj = session.getAttribute("perms");
        if (permsObj != null && permsObj != ""){
            if ((int)permsObj <= 2 && (int)permsObj >= 1){
                if (uuid != null && uuid != "") {
                    map.put("exam", scoreService.selectMarkExamList((String) uuid));
                    map.put("classId", scoreService.classTeacher((String) uuid));
                }else {
                    map.put("exam", new ArrayList<>());
                    map.put("class", new Class());
                }
                return prefix + "/score";
            }else{
                map.put("exam", scoreService.selectStudentExamList((String) uuid));
                return prefix + "/student";
            }
        }else{
            return "/login";
        }
    }

    @PostMapping("/class")
    @ResponseBody
    public List<Class> scoreClass(String examId, HttpServletRequest req){
        HttpSession session = req.getSession();
        Object uuid = session.getAttribute("uuid");
        if (uuid != null && uuid != "") {
            List<Class> list =  scoreService.scoreClass(examId, (String) uuid);
            return list;
        }else {
           return new ArrayList<>();
        }
    }

    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(String examId, String classId, HttpServletRequest req)
    {
        startPage();
        HttpSession session = req.getSession();
        Object uuid = session.getAttribute("uuid");
        if (uuid != null && uuid != "") {
            return getDataTable(scoreService.selectScoreList(examId, classId, (String) uuid));
        }else {
            return getDataTable(new ArrayList<>());
        }
    }

    @PostMapping("/list/score")
    @ResponseBody
    public TableDataInfo listScore(String examId, String classId, String subjectIds, String subjectIdChar){
        startPage();
        return getDataTable(scoreService.listScore(examId, classId, subjectIds, subjectIdChar));
    }

    @PostMapping("/export/score")
    @ResponseBody
    public TableDataInfo exportScore(String examId, String classId, String subjectIds, String subjectIdChar){
        return getDataTable(scoreService.listScore(examId, classId, subjectIds, subjectIdChar));
    }

    @PostMapping("/student/score")
    @ResponseBody
    public TableDataInfo studentScore(String examId, String studentId, String subjectIds, String subjectIdChar){
        startPage();
        if (examId == null || examId == "") {
            return getDataTable(new ArrayList<Score>());
        }
        return getDataTable(scoreService.studentScore(examId, studentId, subjectIds, subjectIdChar));
    }

    @PostMapping("/update")
    @ResponseBody
    public AjaxResult update(Score score){
        try {
            scoreService.updateScore(score);
            return success();
        }catch (Exception e){
            return error(e.getMessage());
        }
    }

    @GetMapping("/show/{classId}")
    public String show(@PathVariable("classId")String classId, ModelMap map){
        map.put("exam", scoreService.selectMyClassExam(classId));
        map.put("classId", classId);
        return prefix + "/show";
    }

    @PostMapping("/subject")
    @ResponseBody
    public List<Subject> subject(String examId){
        return scoreService.selectExamSubject(examId);
    }

    @GetMapping("/importTemplate")
    @ResponseBody
    public AjaxResult importTemplate()
    {
        ExcelUtil<Score> util = new ExcelUtil<Score>(Score.class);
        return util.importTemplateExcel("成绩样例");
    }

    @PostMapping("/importData")
    @ResponseBody
    public AjaxResult importData(MultipartFile file, String examId, String classId) throws Exception
    {
        ExcelUtil<Score> util = new ExcelUtil<Score>(Score.class);
        List<Score> scoreList = util.importExcel(file.getInputStream());
        String message = scoreService.importScore(scoreList, examId, classId);
        return AjaxResult.success(message);
    }

    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(String examId, String classId, HttpServletRequest req)
    {
        startPage();
        HttpSession session = req.getSession();
        Object uuid = session.getAttribute("uuid");
        List<Score> list = null;
        if (uuid != null && uuid != "") {
            list = scoreService.selectScoreList(examId, classId, (String) uuid);
        }
        ExcelUtil<Score> util = new ExcelUtil<Score>(Score.class);
        return util.exportExcel(list, "成绩数据");
    }
}
