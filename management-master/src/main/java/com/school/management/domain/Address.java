package com.school.management.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class Address {

    private static final long serialVersionUID = 1L;

    /** 地区ID */
    private Long addressId;

    /** 父级ID */
    private Long parentId;

    /** 地区名称 */
    private String addressName;

    /** 父级id列表 */
    private String ancestors;

    /** 父级名称列表 */
    private String ancestorsName;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("addressId", getAddressId())
                .append("parentId", getParentId())
                .append("addressName", getAddressName())
                .append("ancestors", getAncestors())
                .append("ancestorsName", getAncestorsName())
                .toString();
    }
}
