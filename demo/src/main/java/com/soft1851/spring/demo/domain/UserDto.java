package com.soft1851.spring.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author zhao
 * @className UserDto
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String userId;
    private List<String> musicList;
}
