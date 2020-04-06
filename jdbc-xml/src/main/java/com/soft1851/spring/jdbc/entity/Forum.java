package com.soft1851.spring.jdbc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhao
 * @className Forum
 * @Description TODO
 * @Date 2020/4/6
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum {
    private Integer forumId;
    private String forumName;
}
