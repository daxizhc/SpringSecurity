package com.imooc.security.dto;

import java.util.Date;

import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.security.validator.DemoConstraint;

import io.swagger.annotations.ApiModelProperty;

public class User {

    public interface UserSimpleView {};

    public interface UserDetailView extends UserSimpleView {};

    private String id;

    @DemoConstraint(message = "测试")
    private String username;

    @NotBlank
    private String password;

    // 接收时间戳后可直接转为Date
    @Past(message = "生日必须为过去的时间")
    @ApiModelProperty(value = "用户生日")
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
