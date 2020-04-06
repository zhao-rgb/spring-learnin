package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhao
 * @className CourseStudent
 * @Description TODO
 * @Date 2020/4/1
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseStudent {
    private Integer id;
    private Integer courseId;
    private Integer studentId;
}
