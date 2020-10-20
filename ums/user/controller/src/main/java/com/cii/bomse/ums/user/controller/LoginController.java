package com.cii.bomse.ums.user.controller;

import com.ciiframework.service.AbstractRestController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @version 1.0
 * @description
 * @auth davidCun
 * @date 2019/3/13 23:36
 */
@Controller
public class LoginController extends AbstractRestController {

    @RequestMapping(path = "/login",method = RequestMethod.GET)
    public String login(){

        return "login";
    }

}
