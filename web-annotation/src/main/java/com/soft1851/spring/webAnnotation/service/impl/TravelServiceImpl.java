package com.soft1851.spring.webAnnotation.service.impl;

import com.soft1851.spring.webAnnotation.dao.TravelDao;
import com.soft1851.spring.webAnnotation.entity.Travel;
import com.soft1851.spring.webAnnotation.service.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhao
 * @className TravelServiceImpl
 * @Description TODO
 * @Date 2020/3/27
 * @Version 1.0
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TravelServiceImpl implements TravelService {

    @Autowired
    private TravelDao travelDao;

    @Override
    public List<Travel> queryAll() {
        return travelDao.selectAll();
    }

    @Override
    public int[] bathInsert(List<Travel> travels) {
        return travelDao.batchInsert(travels);
    }
}
