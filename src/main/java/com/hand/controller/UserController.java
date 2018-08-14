package com.hand.controller;

import com.hand.bean.UserBean;
import com.hand.common.JsonData;
import com.hand.exception.ParamException;
import com.hand.model.User;
import com.hand.service.UserService;
import com.hand.utils.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/getUser/{userId}")
    public ModelAndView getUser(@PathVariable("userId")String userId, ModelAndView mav) {
        User user = userService.getUser(Long.valueOf(userId));
        mav.setViewName("user-edit");
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping("/index")
    public ModelAndView intoIndex(ModelAndView mav, HttpServletRequest request) {
        mav.setViewName("index");
        User user = (User) request.getSession().getAttribute("user");
        mav.addObject(user);
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public JsonData updateUser(UserBean user) {
        userService.updateUser(user);
        return JsonData.success(true);
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public JsonData addUser(User user) {
        userService.addUser(user);
        return JsonData.success(true);
    }

    @RequestMapping("/test")
    @ResponseBody
    public void testE(){
        throw new ParamException();
    }
}
