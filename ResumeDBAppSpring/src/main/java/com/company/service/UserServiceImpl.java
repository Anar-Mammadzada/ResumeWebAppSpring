/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.service;
import com.company.daoImpl.UserRepository;
import com.company.entity.User;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Anar
 */
@Service
@Transactional
public class UserServiceImpl implements UserServiceInter {
    
   UserRepository userDao;
    
    @Override
    public List<User> getAllUser(String name, String surname, Integer nationalityId) {
        return userDao.getAllUser(name, surname, nationalityId);
        }
    
     @Override
    public boolean updateUser(User u) {
       return userDao.updateUser(u);
    }
    
     @Override
    public boolean removeUser(int userId) {
        return userDao.removeUser(userId);
    }
    
     @Override
    public User getById(int userId) {
       return userDao.getById(userId);
    }

    @Override
    public boolean addUser(User u) {
      return userDao.addUser(u);
    }

     @Override
    public User findByEmailAndPassword(String email, String password) {
       return userDao.findByEmailAndPassword(email, password);
    }

    @Override
    public User findByEmail(String email) {
        return userDao.findByEmail(email);
    }

}
