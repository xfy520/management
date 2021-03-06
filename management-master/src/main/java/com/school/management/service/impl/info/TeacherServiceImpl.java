package com.school.management.service.impl.info;

import com.school.management.common.Init;
import com.school.management.common.core.text.Convert;
import com.school.management.domain.Teacher;
import com.school.management.mapper.info.TeacherMapper;
import com.school.management.mapper.info.UserMapper;
import com.school.management.service.info.ITeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Resource
    private UserMapper userMapper;

    /**
     * 新增教师信息
     *
     * @return
     */
    @Override
    public int insertTeacher(Teacher teacher)
    {
        teacher = (Teacher) Init.initUser(teacher, 2);
        if(userMapper.insertUser(teacher) >= 1){
            return teacherMapper.insertTeacher(teacher);
        }
        return 0;
    }

    /**
     * 分配班级
     */
    @Override
    public int updateTeacherClass(Teacher teacher){
        return teacherMapper.updateTeacherClass(teacher);
    }

    /**
     * 更新教师信息
     *
     * @return
     */
    @Override
    public int updateTeacher(Teacher teacher)
    {
        if (userMapper.updateUser(teacher) >=1){
            return teacherMapper.updateTeacher(teacher);
        }
        return 0;
    }

    /**
     * 批量删除教师
     * @param ids
     * @return
     */
    public int deleteTeacherByIds(String ids){
        Long[] userIds = Convert.toLongArray(ids);
        if(userMapper.deleteUserByIds(userIds) >= 1){
            return teacherMapper.deleteTeacherByIds(userIds);
        }
        return 0;
    }

    /**
     * 条件分页查询教师信息
     *
     * @return
     */
    @Override
    public List<Teacher> selectTeacherList(Teacher teacher)
    {
        return teacherMapper.selectTeacherList(teacher);
    }

    /**
     * 条件查询教师信息
     *
     * @return
     */
    @Override
    public Teacher selectTeacherById(Teacher teacher)
    {
        return teacherMapper.selectTeacherById(teacher);
    }
}
