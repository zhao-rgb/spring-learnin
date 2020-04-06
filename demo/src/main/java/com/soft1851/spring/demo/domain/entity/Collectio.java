package com.soft1851.spring.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhao
 * @className Collection
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Collectio {
    private Integer id;
    private String musicId;
    private String userId;
}
