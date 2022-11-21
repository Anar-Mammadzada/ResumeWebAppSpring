/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ResumeWebAppSpring.service;

import com.company.entity.User;
import com.company.servicepack.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anar
 */

@Service
public class CustomUserDetailServiceImpl implements UserDetailsService{
    
    @Autowired
    private UserServiceInter userServ;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       User user =  userServ.findByEmail(username);
       if(user != null){
           UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
           
           builder.disabled(false);
           builder.password(user.getPassword());
           
           String [] authoritiesArr = new String[]{"USER"};
           builder.authorities(authoritiesArr);
           return builder.build();
       }else{
           throw new UsernameNotFoundException("user not found");
       }
    }
    
}
