/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ResumeWebAppSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 *
 * @author Anar
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)throws Exception{
        http
                .authorizeRequests().antMatchers("/login**").permitAll()
                .and().authorizeRequests().antMatchers("/users").hasAnyAuthority("ADMIN","USER")
                .and().authorizeRequests().antMatchers("/foo").hasAnyAuthority("ADMIN","USER")
                .and().authorizeRequests().anyRequest().hasAnyAuthority("ADMIN")
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/users").permitAll()
                .and().logout().logoutSuccessUrl("/login").permitAll()
                .and().csrf().disable();
        
        return http.build();
    }
    
}
