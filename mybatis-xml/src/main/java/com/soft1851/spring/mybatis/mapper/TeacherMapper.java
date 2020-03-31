package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Teacher;

/**
 * @author zhao
 * @className TeacherMapper
 * @Description TODO
 * @Date 2020/3/31
 * @Version 1.0
 **/
public interface TeacherMapper {

    /**
     * 根据teacherId一对一关联查询其管理的班级信息
     * @param teacherId
     * @return
     */
    Teacher getTeacherOneToOne(int teacherId);
}
