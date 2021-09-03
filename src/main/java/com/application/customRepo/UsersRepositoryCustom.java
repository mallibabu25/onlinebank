package com.application.customRepo;

import java.util.List;

import com.application.core.Users;


public interface UsersRepositoryCustom {

	public List<Users> searchUserByLoginId(String searchString) throws Exception;

}
