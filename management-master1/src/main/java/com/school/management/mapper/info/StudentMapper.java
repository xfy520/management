package com.school.management.mapper.info;

import com.school.management.domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 学生信息层 数据层
 *
 */
public interface StudentMapper {

    /**
     * 根据条件分页查询用户列表
     *
     * @return 用户信息集合信息
     */
    List<Student> selectStudentList(Student student);

    /**
     * 根据userId查询单个用户信息
     *
     * @return 单个用户信息
     */
    Student selectStudentById(Student student);

    /** 插入学习年级班级关联 */
    int insertStudent(Student student);

    /** 获取当前最大学号 */
    Long maxStudentId(Student student);

    /** 修改用户信息 */
    int updateStudent(Student student);

    /**
     * 验证身份证号否存在
     * @param idNumber
     * @return
     */
    String checkIdNumberUnique(String idNumber);

    /**
     * 获取考生列表
     */
    List<Student> selectExamineList(@Param("examId") String examId, @Param("classId") String classId,
                                    @Param("subjectId") String subjectId, @Param("userId") Long userId);

    /**
     * 查询学生信息
     * @param userId
     * @return
     */
    List<Student> searchStudentList(@Param("userId") Long userId, @Param("classId") String classId,
                                    @Param("examId") String examId, @Param("subjectId") String subjectId);

}
