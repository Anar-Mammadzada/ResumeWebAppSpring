/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.ResumeWebAppSpring.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 *
 * @author Anar
 */

@Service
public class DummyService {
    
    @PreAuthorize("hasAnyAuthority('USER')")
    public void foo(){
        System.out.println("foo method");
    }
}
