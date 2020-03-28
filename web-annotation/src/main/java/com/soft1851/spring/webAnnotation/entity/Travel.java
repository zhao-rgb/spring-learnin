package com.soft1851.spring.webAnnotation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhao
 * @className Travel
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Travel {
    private Integer id;
    private String cityImage;
    private String cityName;
    private String title;
    private Integer numView;
    private Integer want;
    private Integer numReply;
    private String authorImg;
    private String authorName;
    private String time;
}
