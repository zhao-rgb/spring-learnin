package com.soft1851.spring.webAnnotation.controller;

import com.soft1851.spring.webAnnotation.entity.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhao
 * @className HomeController
 * @Description TODO
 * @Date 2020/3/24 9:46
 * @Version 1.0
 **/
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("message","hello spring mvc~~~");
        Car[] cars = {
                new Car(1,"自行车，又称脚踏车或单车，通常是二轮的小型陆上车辆。人骑上车后，以脚踩踏板为动力，是绿色环保的交通工具。英文bicycle。其中bi意指二，而cycle意指轮，即两轮车。在中国内地、台湾、新加坡，通常称其为“自行车”或“脚踏车”.","http://img2.99114.com/group1/M00/1F/FB/wKgGMFgrtQ-AJ6n0AAKoJfFM_sQ954.jpg","价格为：1,000元"),
                new Car(2,"摩托车，由汽油机驱动，靠手把操纵前轮转向的两轮或三轮车，轻便灵活，行驶迅速，广泛用于巡逻、客货运输等，也用作体育运动器械。从大的方向上来说，摩托车分为街车，公路赛摩托车，越野摩托车，巡航车，旅行车等。","http://img002.hc360.cn/k2/M0A/E7/92/wKhQxVe45tmEC3ZcAAAAAJ4oorg784.jpg","价格为：20,000元"),
                new Car(3,"我国国家最新标准《汽车和挂车类型的术语和定义》(GB/T 3730．1—2001)中对汽车有如下定义：由动力驱动，具有4个或4个以上车轮的非轨道承载的车辆，主要用于：载运人员和（或）货物；牵引载运人员和(或)货物的车辆；特殊用途","https://dss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3161057015,1042861478&fm=26&gp=0.jpg","价格为：100,000")
        };
        List<Car> carList = Arrays.asList(cars);
        model.addAttribute("carList",carList);
        return "home";
    }
}
