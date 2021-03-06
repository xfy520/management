package com.school.management.service.impl.info;

import com.school.management.common.core.text.Convert;
import com.school.management.common.exception.BusinessException;
import com.school.management.common.utils.StringUtils;
import com.school.management.domain.*;
import com.school.management.domain.Class;
import com.school.management.mapper.info.ScoreMapper;
import com.school.management.service.info.IScoreService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.plaf.PanelUI;
import java.util.List;

@Service
public class ScoreServiceImpl implements IScoreService {

    @Resource
    private ScoreMapper scoreMapper;

    @Override
    public List<Exam> selectMarkExamList(String teacherId) {
        return scoreMapper.selectMarkExamList(teacherId);
    }

    /**
     * 查询学生所参加考试
     */
    public List<Exam> selectStudentExamList(String studentId){
        return scoreMapper.selectStudentExamList(studentId);
    }

    /**
     * 验证是不是班主任
     */
    @Override
    public String classTeacher(String teacherId){
        return scoreMapper.classTeacher(teacherId);
    }

    /**
     * 查询指定考试指定老师关联班级
     */
   public List<Class> scoreClass(String examId, String teacherId){
        return scoreMapper.scoreClass(examId, teacherId);
    }

    /**
     * 查询考试班级下的考生
     */
   public List<Score> selectScoreList(String examId, String classId, String teacherId){
        return scoreMapper.selectScoreList(examId, classId, teacherId);
    }

    /**
     * 查询学生成绩
     */
   public List<Object> listScore(String examId, String classId, String subjectIds, String subjectIdChar){
       initSubjectIds(subjectIds, subjectIdChar);
       String sqlStr = initSubjectIds(subjectIds, subjectIdChar);
       return scoreMapper.listScore(examId, classId, sqlStr);
   }

   /**
     * 查询学生成绩
     */
   public List<Object> studentScore(String examId, String studentId, String subjectIds, String subjectIdChar){
       initSubjectIds(subjectIds, subjectIdChar);
       String sqlStr = initSubjectIds(subjectIds, subjectIdChar);
       return scoreMapper.studentScore(examId, studentId, sqlStr);
   }

    private String initSubjectIds(String subjectIds, String subjectIdChar) {
        String[] ids = Convert.toStrArray(subjectIds);
        String[] idChars = Convert.toStrArray(subjectIdChar);
        String sqlStr = "";
        for(int i = 0; i < ids.length; i++){
             sqlStr += "max(CASE WHEN ei.subject_id='" + ids[i] +"' THEN ei.score END) AS " + idChars[i] + ",";
        }
        return sqlStr;
    }

    /**
     * 修改分数
     */
   public int updateScore(Score score){
        return scoreMapper.updateScore(score);
    }

    /**
     * 查询班主任班级所有考试
     */
    public List<Exam> selectMyClassExam(String classId){
        return scoreMapper.selectMyClassExam(classId);
    }

    /**
     * 查询考试科目
     */
    public List<Subject> selectExamSubject(String examId){
        return scoreMapper.selectExamSubject(examId);
    }

    /**
     * 导入学生成绩
     *
     * @return 结果
     */
    @Override
    public String importScore(List<Score> scoreList, String examId, String classId)
    {
        if (StringUtils.isNull(scoreList) || scoreList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        for (Score score : scoreList)
        {
            try
            {
                score.setExamId(examId);
                score.setClassId(classId);
                scoreMapper.importUpdateScore(score);
                successNum++;
                successMsg.append("<br/>" + successNum + "、账号 " + score.getUserName() + " 导入成功");
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 导入失败：";
                failureMsg.append(msg + e.getMessage());
            }
        }
        if (failureNum > 0)
        {
            failureMsg.insert(0, "很抱歉，导入失败！共 " + failureNum + " 条数据格式不正确，错误如下：");
            throw new BusinessException(failureMsg.toString());
        }
        else
        {
            successMsg.insert(0, "恭喜您，数据已全部导入成功！共 " + successNum + " 条，数据如下：");
        }
        return successMsg.toString();
    }
}
