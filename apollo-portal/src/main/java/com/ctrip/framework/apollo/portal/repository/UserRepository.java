package com.ctrip.framework.apollo.portal.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.portal.entity.po.UserPO;

/**
 * @author lepdou 2017-04-08
 */
public interface UserRepository extends PagingAndSortingRepository<UserPO, Long> {

	List<UserPO> findFirst20ByEnabled(int enabled);

	List<UserPO> findByUsernameLikeAndEnabled(String username, int enabled);

	UserPO findByUsername(String username);
}
