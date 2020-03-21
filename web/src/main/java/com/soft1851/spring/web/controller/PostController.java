package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.service.PostService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhao
 * @className PostController
 * @Description TODO
 * @Date 2020/3/21
 * @Version 1.0
 **/
@RestController
@RequestMapping(value = "post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(value = "/list", produces = "application/json; charset=utf-8")
    public String getPosts(){
        ResponseObject ro = new ResponseObject(1,"成功",postService.selectAll());
        return JSON.toJSONString(ro);
    }
}
