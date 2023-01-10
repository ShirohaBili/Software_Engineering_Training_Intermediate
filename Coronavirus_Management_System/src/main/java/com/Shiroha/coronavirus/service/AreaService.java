package com.Shiroha.coronavirus.service;

import com.Shiroha.coronavirus.entity.Area;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface AreaService {

        public List<Area> findAll();


        public boolean add(Area area);


        public Area findByID(int id);
        public boolean update(Area area);

        void deleteArea(int address);

        public Area findByName(String address);
}


