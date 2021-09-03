package com.application.boimpl;

import javax.transaction.Transactional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.bo.UsersBO;
import com.application.core.Users;
import com.application.dao.UsersDAO;


@Service("UsersBO")
@Transactional
public class UsersBOImpl implements UsersBO {
	
	private static final Log log = LogFactory.getLog(UsersBOImpl.class);
	
	@Autowired
	private UsersDAO usersDAO;
	
	@Override
	public Users retrieveUserByLoginId(String loginId) throws Exception {
		try {
			Users user = usersDAO.findByLoginId(loginId);
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


}
