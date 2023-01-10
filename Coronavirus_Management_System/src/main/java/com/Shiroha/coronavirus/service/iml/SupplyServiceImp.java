package com.Shiroha.coronavirus.service.iml;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Shiroha.coronavirus.dao.SupplyDao;
import com.Shiroha.coronavirus.entity.Supply;
import com.Shiroha.coronavirus.service.SupplyService;
import com.github.pagehelper.PageHelper;

@Service
public class SupplyServiceImp implements SupplyService{
    @Autowired
    SupplyDao dao;
    @Override
    public List<Supply> getSupplies(int page, int size) {
        // TODO Auto-generated method stub
        PageHelper.startPage(page, size);
        return dao.getSupplies();
    }

    @Override
    public List<Supply> getSuppliesByName(String name){
        return dao.getSuppliesByName("%" + name + "%");
    }

    @Override
    public void deleteSupplyByID(int ID){  dao.deleteUser(ID);}

    @Override
    public void insertSupply(Supply supply){
        dao.insertSupply(supply);
    }

}