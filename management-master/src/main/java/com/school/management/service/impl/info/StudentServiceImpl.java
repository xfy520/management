package com.school.management.service.impl.info;

import com.school.management.common.Init;
import com.school.management.common.core.text.Convert;
import com.school.management.common.exception.BusinessException;
import com.school.management.common.utils.IDUtils;
import com.school.management.common.utils.StringUtils;
import com.school.management.domain.SchoolRoll;
import com.school.management.domain.Student;
import com.school.management.mapper.info.StudentMapper;
import com.school.management.mapper.info.UserMapper;
import com.school.management.service.info.IStudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
    public int insertStudent(Student student, boolean isSchoolRoll)
    {
        student = (Student) Init.initUser(student, 3);
        if(userMapper.insertUser(student) >= 1){
            if(studentMapper.insertStudent(student) >=1 && isSchoolRoll){
                SchoolRoll schoolRoll = new SchoolRoll();
                schoolRoll.setRollId(IDUtils.getId());
                schoolRoll.setRollNumber(IDUtils.getId());
                schoolRoll.setIdNumber(student.getIdNumber());
                return studentMapper.insertSchoolRoll(schoolRoll);
            }
        }
        return 0;
    }

    /**
     * 导入学生数据
     *
     * @param studentList 用户数据列表
     * @param isUpdateSupport 是否更新支持，如果已存在，则进行更新数据
     * @param operName 操作用户
     * @return 结果
     */
    @Override
    public String importStudent(List<Student> studentList, Boolean isUpdateSupport, String operName)
    {
        if (StringUtils.isNull(studentList) || studentList.size() == 0)
        {
            throw new BusinessException("导入用户数据不能为空！");
        }
        int successNum = 0;
        int failureNum = 0;
        StringBuilder successMsg = new StringBuilder();
        StringBuilder failureMsg = new StringBuilder();
        //String password = configService.selectConfigByKey("sys.user.initPassword");
        for (Student student : studentList)
        {
            System.out.println(student);
            try
            {
//                // 验证是否存在这个用户
//                SysUser u = userMapper.selectUserByLoginName(user.getLoginName());
//                if (StringUtils.isNull(u))
//                {
//                    user.setPassword(Md5Utils.hash(user.getLoginName() + password));
//                    user.setCreateBy(operName);
//                    this.insertUser(user);
//                    successNum++;
//                    successMsg.append("<br/>" + successNum + "、账号 " + user.getLoginName() + " 导入成功");
//                }
//                else if (isUpdateSupport)
//                {
//                    user.setUpdateBy(operName);
//                    this.updateUser(user);
//                    successNum++;
//                    successMsg.append("<br/>" + successNum + "、账号 " + user.getLoginName() + " 更新成功");
//                }
//                else
//                {
//                    failureNum++;
//                    failureMsg.append("<br/>" + failureNum + "、账号 " + user.getLoginName() + " 已存在");
//                }
            }
            catch (Exception e)
            {
                failureNum++;
                String msg = "<br/>" + failureNum + "、账号 " + student.getLoginName() + " 导入失败：";
                failureMsg.append(msg + e.getMessage());
                log.error(msg, e);
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

    /**
     * 删除学生信息
     *
     * @return
     */
    @Override
    public int deleteStudentByIds(String ids)
    {
        Long[] userIds = Convert.toLongArray(ids);
        if(userMapper.deleteUserByIds(userIds) >= 1){
            return studentMapper.deleteStudentByIds(userIds);
        }
        return 0;
    }

    /**
     * 更新学生信息
     *
     * @return
     */
    @Override
    public int updateStudent(Student student)
    {
        return userMapper.updateUser(student);
    }
}
