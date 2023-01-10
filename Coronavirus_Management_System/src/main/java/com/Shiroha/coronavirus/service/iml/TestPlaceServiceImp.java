package com.Shiroha.coronavirus.service.iml;

import java.util.List;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shiroha.coronavirus.dao.TestPlaceDao;
import com.Shiroha.coronavirus.entity.TestPlace;
import com.Shiroha.coronavirus.service.TestPlaceService;

@Service
public class TestPlaceServiceImp implements TestPlaceService {
    @Autowired
    TestPlaceDao dao;

    @Override
    public List<TestPlace> getTestPlaces(int page,int size) {
        // TODO Auto-generated method stub
        PageHelper.startPage(page,size);
        return dao.getTestPlaces();
    }

    /***
     根据名称找到TestPlaces
     * @param name
     */
    public List<TestPlace> getTestPlacesByName(String name) {
        // TODO Auto-generated method stub
//        PageHelper.startPage(page,size);
        return dao.getTestPlacesByName("%" + name + "%");
    }
    
}
