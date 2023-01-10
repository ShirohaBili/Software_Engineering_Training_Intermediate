package com.Shiroha.coronavirus.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.Shiroha.coronavirus.entity.TestPlace;

@Mapper
public interface TestPlaceDao {
    //查找核酸地点
    @Select("select * from test_place")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "place", column = "place"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "time", column = "time")})
    public List<TestPlace> getTestPlaces();

    @Select("select * from test_place where name like #{name}")
    @Results({@Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "place", column = "place"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "time", column = "time")})
    public List<TestPlace> getTestPlacesByName(String name);
}
