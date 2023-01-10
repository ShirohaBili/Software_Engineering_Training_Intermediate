package com.Shiroha.coronavirus.service;/*
Created by shkstart on 2020/3/15.
*/

import com.Shiroha.coronavirus.dao.UserDao;
import com.Shiroha.coronavirus.entity.Authentication;
import com.Shiroha.coronavirus.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userDao.findByUsername(s);
        if(user == null){
            throw new UsernameNotFoundException(s);
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        List<Authentication> authentications = user.getAuthenticationList();
        for(Authentication authentication:authentications){
            authorities.add(new SimpleGrantedAuthority("ROLE_" +authentication.getName()));
        }
//        System.out.println(authorities);
//        System.out.println(user.getPassword());
        org.springframework.security.core.userdetails.User user1=new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
        return user1;
    }
}
