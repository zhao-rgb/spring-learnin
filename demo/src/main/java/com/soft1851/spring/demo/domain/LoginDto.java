package com.soft1851.spring.demo.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhao
 * @className LoginDao
 * @Description TODO
 * @Date 2020/4/3
 * @Version 1.0
 **/

@NoArgsConstructor
@Builder
@Data
public class LoginDto {
    private  String phoneNumber;
    private String password;

    public LoginDto(String phoneNumber, String password) {
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}