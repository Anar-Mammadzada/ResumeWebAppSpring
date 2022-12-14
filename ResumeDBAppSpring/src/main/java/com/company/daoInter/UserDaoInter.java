/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.daoInter;

import com.company.entity.User;
import java.util.List;

/**
 *
 * @author Anar
 */
public interface UserDaoInter {

    public List<User> getAllUser(String name, String surname, Integer nationalityId);

    public boolean updateUser(User u);

    public boolean removeUser(int id);

    public User getById(int id);

    public boolean addUser(User u);
    
    public User findByEmailAndPassword(String email,String password);
    
    public User findByEmail(String email);

}
