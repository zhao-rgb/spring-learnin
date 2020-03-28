package com.soft1851.spring.webAnnotation.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.util.ResponseObject;
import com.soft1851.spring.webAnnotation.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhao
 * @className TopicController
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/")
public class TopicController {
    @Autowired
    private TopicService topicService;

    @GetMapping(value = "topics",produces = "appliacation/json;charset=utf-8")
    @ResponseBody
    public String getTopics(){
        ResponseObject rs = new ResponseObject(1,"success",topicService.queryAll());
        return JSONObject.toJSONString(rs);
    }

//    @GetMapping("/topic")
//    public String topic(Model model){
//        model.addAttribute("topics",topicService.queryAll());
//        return "topic";
//    }

}
