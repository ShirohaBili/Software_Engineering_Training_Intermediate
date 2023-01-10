package com.Shiroha.coronavirus.service.iml;

import com.Shiroha.coronavirus.dao.AuthenticationDao;
import com.Shiroha.coronavirus.entity.Authentication;
import com.Shiroha.coronavirus.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthenticationServiceImp implements AuthenticationService {
    @Autowired
    AuthenticationDao dao;
    @Override
    public List<Authentication> findByUserId(int userId) {
        return dao.findByUserId(userId);
    }
}
