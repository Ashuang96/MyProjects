package com.hand.service;

import com.hand.bean.UserBean;
import com.hand.dao.UserMapper;
import com.hand.exception.ParamException;
import com.hand.model.User;
import com.hand.utils.BeanValidator;
import com.hand.utils.MD5Util;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User getUser(Long id) {
        User user = userMapper.selectByPrimaryKey(id);
        return user;
    }

    public void addUser(User user) {
//        if (existCheck(user.getUserName(), user.getUserId())) {
//            throw new ParamException("该用户已存在");
//        }
        user.setCreationDate(new Date());
        user.setPassword(MD5Util.encrypt(user.getPassword()));
        userMapper.insertSelective(user);
    }

    public void deleteUser(Long id) {
        userMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    public void updateUser(UserBean user) {
//        if (existCheck(user.getUserName(), user.getUserId())) {
//            throw new ParamException("该用户名已存在");
//        }
        User before = userMapper.selectByPrimaryKey(user.getUserId());
        User after = User.builder()
                .userId(before.getUserId())
                .userName(user.getUserName())
                .password(MD5Util.encrypt(user.getPassword()))
                .sex(user.getSex())
                .age(user.getAge())
                .phoneNumber(user.getPhoneNumber())
                .comments(user.getComments())
                .build();
        after.setCreationDate(before.getCreationDate());
        after.setLastUpdateDate(new Date());
        userMapper.updateByPrimaryKeySelective(after);
    }

    public User getUserByUserName(String userName) {
        User user = userMapper.getUserByUserName(userName);
        return user;
    }

    private boolean existCheck(String userName,Long userId) {
        return userMapper.countUserByName(userName, userId) > 0;
    }
}
