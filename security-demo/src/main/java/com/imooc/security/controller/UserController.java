package com.imooc.security.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.security.dto.User;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping
    @JsonView(User.UserSimpleView.class)
    @ApiOperation(value = "用户查询服务")
    public List<User> query(@RequestParam String username){
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    @GetMapping(value = "/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@ApiParam(value = "用户id") @PathVariable String id){
        System.out.println("进入getInfo");
        User user = new User();
        user.setUsername("tom");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult error){
        if(error.hasErrors()){
            for (ObjectError objectError : error.getAllErrors()) {
                System.out.println(objectError.getDefaultMessage());
            }
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @PutMapping(value = "/{id:\\d+}")
    public User update(@Valid @RequestBody User user, BindingResult error){
        if(error.hasErrors()){
            for (ObjectError objectError : error.getAllErrors()) {
                FieldError fieldError = (FieldError)objectError;
                String message = fieldError.getField() + " " + objectError.getDefaultMessage();
                System.out.println(message);
            }
        }
        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    @DeleteMapping(value = "/{id:\\d+}")
    public void delete(@PathVariable String id){
        System.out.println(id);
    }

}
