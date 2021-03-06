package com.school.management.service.impl.info;

import com.school.management.common.core.text.Convert;
import com.school.management.common.exception.BusinessException;
import com.school.management.common.security.Md5Utils;
import com.school.management.common.utils.IDUtils;
import com.school.management.common.utils.StringUtils;
import com.school.management.domain.Student;
import com.school.management.mapper.info.StudentMapper;
import com.school.management.mapper.info.UserMapper;
import com.school.management.service.info.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    private static final Logger log = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private UserMapper userMapper;

    /**
     * 根据条件分页查询用户列表
     *
     * @return 用户信息集合信息
     */
    @Override
    public List<Student> selectStudentList(Student student)
    {
        return studentMapper.selectStudentList(student);
    }

    /**
     * 根据userId查询单个用户信息
     *
     * @return 单个用户信息
     */
    @Override
    public Student selectStudentById(Student student)
    {
        return studentMapper.selectStudentById(student);
    }

    /**
     * 新增学生信息
     *
     * @return
     */
    @Override
    public int insertStudent(Student student)
    {
        Long maxStudentId = studentMapper.maxStudentId(student);
        if (maxStudentId == null){
            Calendar examCalendar = Calendar.getInstance();
            Long yearLong = new Long((long)examCalendar.get(Calendar.YEAR));
            maxStudentId = yearLong * 100000000L + student.getGradeNum() * 1000000 + student.getClassNum() * 10000L + 1L;
        }else{
            maxStudentId = maxStudentId + 1L;
        }
        student.setSchoolId("16c1b605-652a-11ea-bbd0-14dda9bea981");
        return initStudent(student, maxStudentId);
    }

    public int initStudent(Student student, Long maxStudentId){
        student.setId(IDUtils.getId());
        student.setUserId(maxStudentId);
        student.setPassword(Md5Utils.hash("123456"));
        student.setPerms(3);
        if(userMapper.insertUser(student) >= 1){
            return studentMapper.insertStudent(student);
        }
        return 0;
    }

    /**
     * 删除学生信息
     *
     * @return
     */
    @Override
    public int deleteStudentByIds(String ids)
    {
        String[] userIds = Convert.toStrArray(ids);
        return userMapper.deleteUserByIds(userIds);
    }

    /**
     * 更新学生信息
     *
     * @return
     */
    @Override
    public int updateStudent(Student student)
    {
        return studentMapper.updateStudent(student);
    }

    /**
     * 验证身份证号否存在
     * @param idNumber
     * @return
     */
    @Override
    public String checkIdNumberUnique(String idNumber) {
        return studentMapper.checkIdNumberUnique(idNumber);
    }
}
