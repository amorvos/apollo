package com.ctrip.framework.apollo.openapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.openapi.entity.Consumer;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
public interface ConsumerRepository extends PagingAndSortingRepository<Consumer, Long> {

	Consumer findByAppId(String appId);

}
