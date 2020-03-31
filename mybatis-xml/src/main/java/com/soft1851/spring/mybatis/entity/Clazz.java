package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhao
 * @className Clazz
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Clazz {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;
    private Teacher teacher;
    private List<Student> students;
}
