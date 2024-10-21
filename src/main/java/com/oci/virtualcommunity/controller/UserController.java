package com.oci.virtualcommunity.controller;

import com.oci.virtualcommunity.entity.User;
import com.oci.virtualcommunity.service.IUserService;
import com.oci.virtualcommunity.util.restful.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    IUserService userService;
    @Autowired
    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseResult<User> add(@Validated @RequestBody User user){
        User add = userService.add(user);
        return new ResponseResult<>(500,"success",add);
    }
    @GetMapping
    public ResponseResult<User> select(@RequestParam Integer userId){
        User select = userService.select(userId);
        if(select == null){
            return new ResponseResult<>(501,"error", null);
        }
        return new ResponseResult<>(500,"success",select);
    }
    @DeleteMapping
    public ResponseResult<User> delete(@RequestParam Integer userId){
        userService.delete(userId);
        return new ResponseResult<>(500,"success",null);
    }
    @PutMapping
    public ResponseResult<User> update(@Validated @RequestBody User user){
        User update = userService.update(user);
        if(update == null){
            return new ResponseResult<>(501,"error", null);
        }
        return new ResponseResult<>(500,"success",update);
    }
}
