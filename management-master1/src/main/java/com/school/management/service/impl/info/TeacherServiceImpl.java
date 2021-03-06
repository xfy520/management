package com.school.management.service.impl.info;

import com.school.management.common.core.text.Convert;
import com.school.management.common.security.Md5Utils;
import com.school.management.common.utils.IDUtils;
import com.school.management.domain.Class;
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
        teacher.setId(IDUtils.getId());
        teacher.setPassword(Md5Utils.hash("123456"));
        teacher.setPerms(2);
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
     * 查询教师所上班级
     */
    public List<Class> classSearch(Teacher teacher){
        return teacherMapper.classSearch(teacher);
    }

    /**
     * 更新教师信息
     *
     * @return
     */
    @Override
    public int updateTeacher(Teacher teacher)
    {
        return teacherMapper.updateTeacher(teacher);
    }

    /**
     * 批量删除教师
     * @param ids
     * @return
     */
    public int deleteTeacherByIds(String ids){
        String[] userIds = Convert.toStrArray(ids);
        return userMapper.deleteUserByIds(userIds);
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
     * 班级搜索教师
     */
    public List<Teacher> searchTeacherList(Teacher teacher){
        return teacherMapper.searchTeacherList(teacher);
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

    /**
     * 验证账号是否存在
     * @param userId
     * @return
     */
    @Override
    public String checkUserIdUnique(Long userId) {
        return teacherMapper.checkUserIdUnique(userId);
    }

}
