package com.application.restcontroller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.application.bo.UsersBO;
import com.application.common.CommonController;

@Controller
@RequestMapping("/userrest/")
public class UsersRest extends CommonController {
	private static final Log log = LogFactory.getLog(UsersRest.class);
	
	@Autowired
	private UsersBO usersBO;
}
