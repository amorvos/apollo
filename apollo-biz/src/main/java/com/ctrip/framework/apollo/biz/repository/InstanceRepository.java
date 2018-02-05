package com.ctrip.framework.apollo.biz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.biz.entity.Instance;

public interface InstanceRepository extends PagingAndSortingRepository<Instance, Long> {
	Instance findByAppIdAndClusterNameAndDataCenterAndIp(String appId, String clusterName, String dataCenter,
			String ip);
}
