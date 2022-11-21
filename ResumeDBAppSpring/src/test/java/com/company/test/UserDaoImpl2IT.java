package com.company.test;

import com.company.ResumeDbAppSpringApplication;
import com.company.daoImpl.UserRepository;
import com.company.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ResumeDbAppSpringApplication.class})
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserDaoImpl2IT {

    @Autowired
    UserRepository userRepo;


    @Test
    public void testGetAll(){
             List<User> list = userRepo.getAllUser(null,null,null);
        System.out.println("list= " + list);
        Assert.assertEquals("user size must be 1",2, list.size());
    }
}
