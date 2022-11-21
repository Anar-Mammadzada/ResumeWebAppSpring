package com.company.ResumeWebAppSpring.controller;

import com.company.ResumeWebAppSpring.form.UserForm;
import com.company.ResumeWebAppSpring.service.DummyService;
import com.company.entity.User;
import com.company.servicepack.UserServiceInter;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Anar
 */
@Controller
public class UserController {

    @Autowired
    private UserServiceInter userService;

//    @RequestMapping(method = RequestMethod.GET, value = "/users")
//    public String index(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        String nationalityIdStr = request.getParameter("natId");
//        Integer nationalityId = null;
//        if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
//            nationalityId = Integer.parseInt(nationalityIdStr);
//        }
//        List<User> list = userService.getAllUser(name, surname, nationalityId);
//        request.setAttribute("list", list);
//        return "users";
//    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(@RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "surname", required = false) String surname,
            @RequestParam(value = "nid", required = false) Integer nationalityId) {
        List<User> list = userService.getAllUser(name, surname, nationalityId);
        ModelAndView mv = new ModelAndView("users");
        mv.addObject("users", list);
        return mv;

    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/usersm")
    public ModelAndView indexM(@Valid @ModelAttribute("user") UserForm u,BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("users");
        if(bindingResult.hasErrors()){
            return mv;
        }
        List<User> list = userService.getAllUser(u.getName(), u.getSurname(), u.getNationalityId());
        
        mv.addObject("users", list);
        return mv;

    }
    
    @Autowired
    private DummyService dummy;
    
    @RequestMapping(method = RequestMethod.GET, value = "/foo")
    public String foo(){
        System.out.println("foo in controller");
        dummy.foo();
        return "users";
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login(){
        return "login";
    }
    
    @ModelAttribute("user")
    public UserForm getEmptyUserForm(){
        return new UserForm();
    }
}
