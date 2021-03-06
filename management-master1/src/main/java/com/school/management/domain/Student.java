package com.school.management.domain;

import com.school.management.common.annotation.Excel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class Student extends User{

    /** 学校id */
    private String schoolId;

    /** 学校名称 */
    private String schoolName;

    /** 年级id */
    private String gradeId;

    /** 年级名次 */
    private String gradeName;

    /** 班级id */
    private String classId;

    /** 班级名称 */
    private String className;

    /** 年级序号 */
    private Long gradeNum;

    /** 班级序号 */
    private Long classNum;

    private String idNumber;

    /** 用户邮箱 */
    private String email;

    /** 手机号码 */
    private String phoneNumber;

    /** 住址 */
    private Long address;

    /** 住址 */
    private String addressName;

    /** 地址父级id列表 */
    private String addressParentIds;

    /** 用户性别 */
    private String sex;

    @Email(message = "邮箱格式不正确")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }
}
