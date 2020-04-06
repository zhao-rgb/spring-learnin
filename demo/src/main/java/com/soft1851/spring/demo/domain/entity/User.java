package com.soft1851.spring.demo.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @author zhao
 * @className User
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String salt;
    private String email;
    private Integer phoneNumber;
    private Integer status;
    private Integer binding;
    private Integer credits;
    private LocalDate createTime;
    private LocalDate lastLoginTime;
}
