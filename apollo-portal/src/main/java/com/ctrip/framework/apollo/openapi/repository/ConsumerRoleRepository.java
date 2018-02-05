package com.ctrip.framework.apollo.openapi.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.openapi.entity.ConsumerRole;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
public interface ConsumerRoleRepository extends PagingAndSortingRepository<ConsumerRole, Long> {
	/**
	 * find consumer roles by userId
	 *
	 * @param consumerId
	 *            consumer id
	 */
	List<ConsumerRole> findByConsumerId(long consumerId);

	/**
	 * find consumer roles by roleId
	 */
	List<ConsumerRole> findByRoleId(long roleId);

	ConsumerRole findByConsumerIdAndRoleId(long consumerId, long roleId);
}
