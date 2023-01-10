package com.Shiroha.coronavirus.service;

import java.util.List;

import com.Shiroha.coronavirus.entity.TestPlace;

public interface TestPlaceService {
    public List<TestPlace> getTestPlaces(int page,int size);
    public List<TestPlace> getTestPlacesByName(String name);
}
