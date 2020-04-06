package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhao
 * @className Course
 * @Description TODO
 * @Date 2020/4/1
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    /**
     * 课程id
     */
    private Integer courseId;
    /**
     * 课程名称
     */
    private String courseName;
    /**
     * 课程学生列表
     */
    private List<Student> students;
}