package com.Shiroha.coronavirus.service.iml;

import com.Shiroha.coronavirus.dao.AreaDao;
import com.Shiroha.coronavirus.entity.Area;
import com.Shiroha.coronavirus.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AreaServiceImp implements  AreaService{
        @Autowired
        AreaDao dao;

        @Override
        public Area findByID(int id) {
            return dao.findByID(id);
        }

        @Override
        public boolean add(Area area) {
           return dao.add(area);
        }

        @Override
        public void deleteArea(int address) {
            dao.deleteArea(address);
        }

        @Override
        public List<Area> findAll() {
            return dao.findAll();
        }

        @Override
        public boolean update(Area area) {
           return dao.update(area);
        }

        public Area findByName(String address){return dao.findByName(address);}
}
