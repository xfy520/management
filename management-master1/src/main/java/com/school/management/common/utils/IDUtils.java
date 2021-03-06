package com.school.management.common.utils;

import java.util.UUID;

public class IDUtils {

    public static String getId()
    {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    public static void main(String[] args) {
        System.out.println(getId());
    }
}
