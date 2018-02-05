package com.ctrip.framework.apollo.portal.spi.springsecurity;

import java.security.Principal;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import com.ctrip.framework.apollo.portal.entity.bo.UserInfo;
import com.ctrip.framework.apollo.portal.spi.UserInfoHolder;

public class SpringSecurityUserInfoHolder implements UserInfoHolder {

	@Override
	public UserInfo getUser() {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserId(getCurrentUsername());
		return userInfo;
	}

	private String getCurrentUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		if (principal instanceof Principal) {
			return ((Principal) principal).getName();
		}
		return String.valueOf(principal);
	}

}
