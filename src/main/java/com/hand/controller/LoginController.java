package com.hand.controller;

import com.hand.model.User;
import com.hand.service.UserService;
import com.hand.utils.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("login")
    public void Login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        User user = userService.getUserByUserName(userName);
        String errorMsg = "";
        if (StringUtils.isBlank(userName)) {
            errorMsg = "用户名不可以为空";
        }
        else if (StringUtils.isBlank(password)) {
            errorMsg = "密码不可以为空";
        }
        else if (user == null) {
            errorMsg = "没有该用户";
        }
        else if (!user.getPassword().equals(MD5Util.encrypt(password))) {
            errorMsg = "用户名或密码错误";
        } else {
            request.getSession().setAttribute("user", user);
            response.sendRedirect("/management/user/index");
            return;
        }
        request.setAttribute("error", errorMsg);
        request.setAttribute("username", userName);
        String path = "login.jsp";
        request.getRequestDispatcher(path).forward(request, response);
    }

    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().invalidate();
        String path = "login.jsp";
        response.sendRedirect(path);
    }
}