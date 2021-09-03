package com.application.bo;

import com.application.core.Users;

public interface UsersBO {

	Users retrieveUserByLoginId(String name) throws Exception;

}
