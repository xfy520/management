package com.school.management.common;

import com.school.management.common.security.Md5Utils;
import com.school.management.common.utils.IDUtils;
import com.school.management.domain.User;

public class Init {

    public static User initUser(User user, int perms){
        user.setUserId(IDUtils.getId());
        user.setPassword(Md5Utils.hash(user.getPassword()));
        user.setStatus("0");
        user.setDelFlag("0");
        user.setPerms(perms);
        user.setAvatar("/img/profile.jpg");
        return user;
    }
}
