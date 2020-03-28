package com.soft1851.spring.webAnnotation.controller;

import com.alibaba.fastjson.JSONObject;
import com.soft1851.spring.web.util.ResponseObject;
import com.soft1851.spring.webAnnotation.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhao
 * @className TravelController
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/")
public class TravelController {

    @Autowired
    private TravelService travelService;

    @GetMapping(value = "travels",produces = "appliacation/json;charset=utf-8")
    @ResponseBody
    public String getTravels(){
        ResponseObject rs = new ResponseObject(1,"success",travelService.queryAll());
        return JSONObject.toJSONString(rs);
    }

    @GetMapping("/travel")
    public String travel(Model model){
        model.addAttribute("travels",travelService.queryAll());
        return "travel";
    }
}
