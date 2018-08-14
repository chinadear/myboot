package com.bootplus.core.component;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.bootplus.controller.LoginController;
import com.bootplus.dao.IUserDao;

@Component
@Transactional
public class AuthUserDetailsServiceImpl implements UserDetailsService {
	
	private final Logger logger=LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private IUserDao baseDao;
	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.bootplus.model.UserLogin user = baseDao.findUserByName(s);
		if(user==null) {
			throw new BadCredentialsException("no user");
		}
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("admin"));
        return new User(user.getUsername(), user.getPassword(), authorities);
	}

}
