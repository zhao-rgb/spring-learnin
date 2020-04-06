package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhao
 * @className Music
 * @Description TODO
 * @Date 2020/4/2
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Music {
    private Integer id;
    private String  url;
    private String  musicName;
}
