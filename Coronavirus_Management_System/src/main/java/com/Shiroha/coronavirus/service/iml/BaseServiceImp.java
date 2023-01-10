package com.Shiroha.coronavirus.service.iml;

import com.Shiroha.coronavirus.service.BaseService;
import com.Shiroha.coronavirus.dao.BaseDao;
import com.Shiroha.coronavirus.entity.Base;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BaseServiceImp implements BaseService {

    @Autowired
    BaseDao dao;

    @Override
    public List<Base> findAll() {
        return null;
    }

    @Override
    public Base findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void delete(int id) {
        dao.delete(id);
    }

    @Override
    public void add(Base base) {
        dao.add(base);
    }

    @Override
    public Base findByIdCard(String idCard) {
        return dao.findByIdCard(idCard);
    }

    @Override
    public void update(Base base) {
        dao.update(base);
    }
}
