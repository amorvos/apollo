package com.ctrip.framework.apollo.portal.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.portal.entity.po.Role;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
	/**
	 * find role by role name
	 */
	Role findTopByRoleName(String roleName);
}
