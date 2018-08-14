package com.hand.bean;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;

@Getter
@Setter
@ToString
public class UserBean {

    private Long userId;

    @NotBlank(message = "用户名不能为空")
    private String userName;

    @NotBlank(message = "密码不能为空")
    private String password;

    @NotBlank(message = "性别不能为空")
    private String sex;

    private Long age;

    @NotBlank(message = "电话号码不能为空")
    private String phoneNumber;

    private String comments;
}
