package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Course;

/**
 * @author zhao
 * @className CourseMapper
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
public interface CourseMapper {

    /**
     * 根据班级id查询班课详情(班级自身信息，学生列表)
     * @param courseId
     * @return
     */
    Course getCourseById(int courseId);
}
