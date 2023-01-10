package com.Shiroha.coronavirus.service;

import com.Shiroha.coronavirus.entity.Dead;
import java.util.List;

public interface DeadService {

    void add(Dead dead);
    List<Dead> findAll(int page, int size);
    Dead get(int id);
    int number();
    List<Dead> findByName(String name);
}
