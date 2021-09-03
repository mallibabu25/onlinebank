package com.application.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.application.core.Users;
import com.application.customRepo.UsersRepositoryCustom;


@Repository
public class UserDAOImpl implements UsersRepositoryCustom {
	
	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public List<Users> searchUserByLoginId(String searchString) throws Exception {
		List<Users> users = new ArrayList<Users>();
		try {
			String queryString = "select distinct u from Users u  where u.loginId like :searchString ";
			Query query = entityManager.createQuery(queryString);
			query.setParameter("searchString", "%"+searchString+"%");
			return query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

}
