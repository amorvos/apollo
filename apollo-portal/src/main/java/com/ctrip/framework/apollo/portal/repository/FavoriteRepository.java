package com.ctrip.framework.apollo.portal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.portal.entity.po.Favorite;

public interface FavoriteRepository extends PagingAndSortingRepository<Favorite, Long> {

	List<Favorite> findByUserIdOrderByPositionAscDataChangeCreatedTimeAsc(String userId, Pageable page);

	List<Favorite> findByAppIdOrderByPositionAscDataChangeCreatedTimeAsc(String appId, Pageable page);

	Favorite findFirstByUserIdOrderByPositionAscDataChangeCreatedTimeAsc(String userId);

	Favorite findByUserIdAndAppId(String userId, String appId);
}
