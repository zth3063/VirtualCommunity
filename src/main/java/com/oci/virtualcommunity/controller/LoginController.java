package com.oci.virtualcommunity.controller;

import com.oci.virtualcommunity.entity.User;
import com.oci.virtualcommunity.service.IUserService;
import com.oci.virtualcommunity.util.restful.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    IUserService userService;
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/login")
    public ModelAndView Login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        return  modelAndView;
    }
    @RequestMapping("/userLogin")
    @ResponseBody
    public ResponseResult<Object> UserLogin(@RequestBody User user){
        User user1 = userService.selectByName(user.getUserName());
        if(user1 == null){
            return new ResponseResult<>(505,"用户名不存在",null);
        }
        if(user1.getPassword().equals(user.getPassword())){
            return new ResponseResult<>(500,"success",null);
        }else{
            return new ResponseResult<>(504,"密码错误",null);
        }
    }
}
