package com.ctrip.framework.apollo.portal.entity.bo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class UserInfo {

	private String userId;

	private String name;

	private String email;

	@Override
	public boolean equals(Object o) {
		if (o instanceof UserInfo) {
			if (o == this) {
				return true;
			}
			UserInfo anotherUser = (UserInfo) o;
			return userId.equals(anotherUser.userId);
		} else {
			return false;
		}

	}
}
