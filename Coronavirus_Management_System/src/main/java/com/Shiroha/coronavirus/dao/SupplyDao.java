package com.Shiroha.coronavirus.dao;

import java.util.List;

import org.apache.ibatis.annotations.*;

import com.Shiroha.coronavirus.entity.Supply;

@Mapper
public interface SupplyDao {
    //查找库存物资
    @Select("select * from supply")
    @Results({
        @Result(id = true, property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "price", column = "price"),
        @Result(property = "amount", column = "amount")})
        public List<Supply> getSupplies();

    //按名称查询
    @Select("select * from supply where name like #{name}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "price", column = "price"),
            @Result(property = "amount", column = "amount"),
            @Result(property = "illness", column = "illness")})
    public List<Supply> getSuppliesByName(String name);

    @Delete("delete from supply where id=#{id}")
    public void deleteUser(int id);

    @Insert("insert into supply(id,name,price,amount,illness) values(#{id},#{name},#{price},#{amount},#{illness})")
    public void insertSupply(Supply supply);
}
