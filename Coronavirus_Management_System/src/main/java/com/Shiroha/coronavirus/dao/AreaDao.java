package com.Shiroha.coronavirus.dao;

import com.Shiroha.coronavirus.entity.Area;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper

public interface AreaDao {

        //查找所有地区
        @Select("select id,address,level from area")
        public List<Area> findAll();
        //添加地区
        @Insert("insert into area(id,address,level)values(#{id},#{address},#{level})")
        public boolean add(Area area);
        //根据编号查找地区
        @Select("select id,address,level from area where id = #{id} ")
        public Area findByID(int id);
        //更改风险级别
        @Update("update area set level=#{level} where id=#{id}")
        public boolean update(Area area);
        //删除地区
        @Delete("delete from area where id=#{id}")
        public void deleteArea(int id);

        @Select("select id,address,level from area where address like #{address}")
        public Area findByName(String address);
    }


