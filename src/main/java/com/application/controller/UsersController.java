package com.application.controller;


import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.application.bo.UsersBO;
import com.application.common.CommonController;
import com.application.common.SecurityContextUtils;
import com.application.core.Users;


@Controller
@RequestMapping("/")
public class UsersController extends CommonController {
	private static final Log log = LogFactory.getLog(UsersController.class);

	
	@Autowired
	private UsersBO usersBO;

	@RequestMapping( value = { "/login"},  method = RequestMethod.GET)
    public ModelAndView login(String msg,HttpSession session) {
		try {
			Users user = (Users) session.getAttribute("userobj");
			if(user != null && StringUtils.isNotBlank(user.getLoginId())) {
				
			    return new ModelAndView("redirect:checkLogin");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
        return new ModelAndView("login").addObject("msg",msg);
    }
	
	@RequestMapping( value = { "/checkLogin"},  method = RequestMethod.GET)
    public ModelAndView checkLogin(HttpSession session) {
		try {
			String name = SecurityContextUtils.getUserId();
			Users user = new Users();
			user = usersBO.retrieveUserByLoginId(name);
			session.setAttribute("userobj", user);
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:auth");
		}
		return new ModelAndView("redirect:dashboard");
    }
	
	@RequestMapping( value = { "/dashboard"},  method = RequestMethod.GET)
    public ModelAndView dashboard() {
        return new ModelAndView("login").addObject("msg","login successfully");
    }
}
