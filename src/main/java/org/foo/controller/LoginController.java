package org.foo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping(value = {"/login","/"})
    public String login(){

        return "login";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

}