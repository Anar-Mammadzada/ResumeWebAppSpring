package com.company.test;

import com.company.daoImpl.UserDaoImpl;
import com.company.daoImpl.UserRepository;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.service.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

    @Mock
    public UserDaoImpl userDao;

    @InjectMocks
    UserServiceImpl userService;

    @BeforeClass
    public static void setUp(){
        System.out.println("set up called");
    }

    @Before
    public void before(){
        System.out.println("before calleed");
        MockitoAnnotations.initMocks(this);
        List<User> list = new ArrayList<>();
        User u = new User();
        u.setName("test");
        u.setSurname("test");
        u.setEmail("test@test.com");
        u.setNationalityId(new Country(1));
        list.add(u);

        Mockito.when(userDao.getAllUser(null,null,null)).thenReturn(list);

        Mockito.when(userDao.getAllUser("test","test",1)).thenReturn(list);

        Mockito.when(userDao.findByEmailAndPassword(null,null)).thenReturn(null);
    }

    @Test
    public void testGivenNullThenGetAll(){
        List<User> list = userService.getAllUser(null,null,null);
        Assert.assertEquals("usersize must be 1",1,list.size());
        Mockito.verify(userDao, Mockito.atLeastOnce()).getAllUser(null,null,null);
    }

    @Test
    public void testGivenAllParamsThenGetAll(){
        List<User> list = userService.getAllUser("test","test",1);
        Assert.assertTrue("usersize must be grater than zero",list.size() > 0);

        User user = list.get(0);

        Assert.assertEquals("name wrong", "test", user.getName());
        Assert.assertEquals("surname wrong", "test", user.getSurname());
        Assert.assertEquals("natId wrong", 1L, (long) user.getNationality().getId());

        Mockito.verify(userDao, Mockito.atLeastOnce()).getAllUser("test","test",1);
    }

    @Test
    public void testFindByEmailAndPassword(){
        User user = userService.findByEmailAndPassword(null,null);
        Assert.assertNull("user must be null",user);

        Mockito.verify(userDao, Mockito.atLeastOnce()).findByEmailAndPassword(null,null);
    }

}
