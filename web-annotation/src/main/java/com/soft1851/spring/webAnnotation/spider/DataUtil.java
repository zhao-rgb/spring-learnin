package com.soft1851.spring.webAnnotation.spider;

import java.util.Random;

/**
 * @author zhao
 * @className DataUtil
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
public class DataUtil {

    public static Integer Id(){
        Random random = new Random();
        int bound = random.nextInt(72)+1;
        return bound;
    }

}
