package com.Shiroha.coronavirus.service;

import com.Shiroha.coronavirus.entity.Authentication;

import java.util.List;

public interface AuthenticationService {
    public List<Authentication> findByUserId(int userId);
}
