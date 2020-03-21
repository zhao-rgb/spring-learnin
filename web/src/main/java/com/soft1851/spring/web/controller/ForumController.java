package com.soft1851.spring.web.controller;

import com.alibaba.fastjson.JSON;
import com.soft1851.spring.web.service.ForumService;
import com.soft1851.spring.web.util.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zhao
 * @className ForumController
 * @Description TODO
 * @Date 2020/3/20 14:38
 * @Version 1.0
 **/

@RestController
@RequestMapping(value = "forum")
public class ForumController {

    @Autowired
    private ForumService forumService;

    @RequestMapping(value = "/list", produces = "application/json; charset=utf-8")
    public String getForums(){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.selectAll());
        return JSON.toJSONString(ro);
    }

    @RequestMapping(value = "/ForumId", produces = "application/json; charset=utf-8")
    public String getForumId(){
        ResponseObject ro = new ResponseObject(1,"成功",forumService.get(1));
        return JSON.toJSONString(ro);
    }

}
