package com.application.common;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.application.core.Users;


@Service("loginService")
public class LoginService implements UserDetailsService{
	
	private static final Log log = LogFactory.getLog(LoginService.class);
	private EntityManager entityManager;

	@PersistenceContext
    public void setEntityManager(EntityManager entityManager){
        this.entityManager = entityManager;
    }
	
	@Override
    public UserDetails loadUserByUsername(String userid)throws UsernameNotFoundException, DataAccessException {
		UserDetails ud = null;
		try {
			Users users = null;
			try{
				
				 users = (Users)entityManager.createQuery("select u from Users u  where u.loginId = :loginId ").setParameter("loginId", userid).getSingleResult();
				 
				 
			}catch (NoResultException e) {
				log.info("userid not found");
				 
			}
			if(users == null){
				throw new UsernameNotFoundException("Username not found"); 
			}
			Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

			
			authorities.add(new SimpleGrantedAuthority("ROLE"));
			
//			@SuppressWarnings("unchecked")
//			List<String> rolesList = entityManager.createNativeQuery("select p.privilege_code from users u, role_privilege rp, privilege p, users_role ur where u.user_id = ur.users_id and ur.role_id = rp.role_id and rp.privilege_id = p.privilege_id and u.login_id = :userid")
//					.setParameter("userid", userid).getResultList();
//
//			for (String rolestring: rolesList)
//				authorities.add(new SimpleGrantedAuthority(rolestring));

			ud = new User(users.getLoginId() , users.getPassword(), authorities);
		}
		catch(UsernameNotFoundException ue){
			throw ue;
		}
		catch (Exception e) {
			log.error("---------------Failed To Retrieve User------------------",e);
		}
		return ud;
	}
}
