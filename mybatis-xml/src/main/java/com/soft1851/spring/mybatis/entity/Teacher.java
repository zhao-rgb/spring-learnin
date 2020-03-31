package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhao
 * @className Teacher
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private Integer teacherId;
    private String teacherName;
    private Integer clazzId;
//    一对一映射关系
    private Clazz clazz;
}
