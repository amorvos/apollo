package com.ctrip.framework.apollo.biz.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.biz.entity.GrayReleaseRule;

public interface GrayReleaseRuleRepository extends PagingAndSortingRepository<GrayReleaseRule, Long> {

	GrayReleaseRule findTopByAppIdAndClusterNameAndNamespaceNameAndBranchNameOrderByIdDesc(String appId,
			String clusterName, String namespaceName, String branchName);

	List<GrayReleaseRule> findByAppIdAndClusterNameAndNamespaceName(String appId, String clusterName,
			String namespaceName);

	List<GrayReleaseRule> findFirst500ByIdGreaterThanOrderByIdAsc(Long id);

}
