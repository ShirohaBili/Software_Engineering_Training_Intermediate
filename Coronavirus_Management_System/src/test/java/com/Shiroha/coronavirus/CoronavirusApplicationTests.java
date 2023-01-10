package com.Shiroha.coronavirus;

import com.Shiroha.coronavirus.service.BaseService;
import com.Shiroha.coronavirus.dao.BaseDao;
import com.Shiroha.coronavirus.dao.PatientDao;
import com.Shiroha.coronavirus.entity.Base;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;

@SpringBootTest
class CoronavirusApplicationTests {

    @Autowired
    BaseDao dao;

    PatientDao da;

    @Autowired
    BaseService baseService;


    @Test
    void baseInsert() {
        Base base = new Base();
        base.setIdCard("513042198810241233");
        base.setName("安没");
        base.setAge(22);
        base.setGender('男');
        base.setAddress("美国");
        base.setPhone(new BigInteger("123456789"));
        baseService.add(base);
    }

    @Test
    void baseFind() {
        Base base = baseService.findById(78);
        System.out.println(base);
    }

}
