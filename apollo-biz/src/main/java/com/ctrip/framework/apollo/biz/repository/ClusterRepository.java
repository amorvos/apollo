package com.ctrip.framework.apollo.biz.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.biz.entity.Cluster;

public interface ClusterRepository extends PagingAndSortingRepository<Cluster, Long> {

	List<Cluster> findByAppIdAndParentClusterId(String appId, Long parentClusterId);

	List<Cluster> findByAppId(String appId);

	Cluster findByAppIdAndName(String appId, String name);

	List<Cluster> findByParentClusterId(Long parentClusterId);
}
