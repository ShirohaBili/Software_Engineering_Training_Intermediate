package com.Shiroha.coronavirus.service;

import java.util.List;

import com.Shiroha.coronavirus.entity.Supply;

public interface SupplyService {
    public List<Supply> getSupplies(int page,int size);
    public List<Supply> getSuppliesByName(String name);
    public void deleteSupplyByID(int ID);
    public void insertSupply(Supply supply);
}
