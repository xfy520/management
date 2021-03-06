package com.school.management.domain;

import com.school.management.common.annotation.Excel;
import com.school.management.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 用户对象 user
 *
 */
@Data
public class User extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @Excel(name = "用户序号", cellType = Excel.ColumnType.NUMERIC, prompt = "用户编号")
    private Long userId;

    @Excel(name = "身份证号码", cellType = Excel.ColumnType.STRING, prompt = "身份证号码")
    private String idNumber;

    /** 登录名称 */
    @Excel(name = "登录名称")
    private String loginName;

    /** 用户名称 */
    @Excel(name = "用户姓名")
    private String userName;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phoneNumber;

    /** 用户性别 */
    @Excel(name = "用户性别", readConverterExp = "0=男,1=女,2=未知")
    private String sex;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 住址 */
    private Long address;

    /** 住址 */
    @Excel(name = "地址名称")
    private String addressName;

    /** 地址父级id列表 */
    private String addressParentIds;

    /** 标志账号状态 */
    private String status;

    /** 标志身份 */
    private int perms;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    /** 备注信息 */
    private String remark;

    @Size(min = 0, max = 30, message = "登录账号长度不能超过30个字符")
    public String getLoginName()
    {
        return loginName;
    }

    @Size(min = 0, max = 30, message = "用户姓名长度不能超过30个字符")
    public String getUserName()
    {
        return userName;
    }

    @Email(message = "邮箱格式不正确")
    @Size(min = 0, max = 50, message = "邮箱长度不能超过50个字符")
    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @Size(min = 0, max = 11, message = "手机号码长度不能超过11个字符")
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("userId", getUserId())
                .append("idNumber", getIdNumber())
                .append("loginName", getLoginName())
                .append("userName", getUserName())
                .append("email", getEmail())
                .append("phoneNumber", getPhoneNumber())
                .append("sex", getSex())
                .append("avatar", getAvatar())
                .append("password", getPassword())
                .append("delFlag", getDelFlag())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .append("remark", getRemark())
                .append("address", getAddress())
                .append("addressName", getAddressName())
                .toString();
    }
}
