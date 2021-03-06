package com.school.management.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IDUtils {

    private static final Logger log = LoggerFactory.getLogger(IDUtils.class);

    private static long tmpID = 0;

    private static boolean tmpIDlocked = false;

    public static long getId()
    {
        long ltime = 0;
        try {
            while (true)
            {
                if(tmpIDlocked == false)
                {
                    tmpIDlocked = true;
                    //当前：（年、月、日、时、分、秒、毫秒）*10000
                    ltime = Long.valueOf(new SimpleDateFormat("yyMMddhhmmssSSS").format(new Date()).toString()) * 10000;
                    if(tmpID < ltime)
                    {
                        tmpID = ltime;
                    }
                    else
                    {
                        tmpID = tmpID + 1;
                        ltime = tmpID;
                    }
                    tmpIDlocked = false;
                    return ltime;
                }
            }
        }catch (Exception e)
        {
            log.error("not supported charset...{}", e);
            return ltime;
        }
    }

    public static void main(String[] args) {
        System.out.println(getId()/1000000L);
    }
}
