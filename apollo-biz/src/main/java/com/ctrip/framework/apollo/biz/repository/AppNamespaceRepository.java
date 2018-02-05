package com.ctrip.framework.apollo.biz.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.common.entity.AppNamespace;

public interface AppNamespaceRepository extends PagingAndSortingRepository<AppNamespace, Long> {

	AppNamespace findByAppIdAndName(String appId, String namespaceName);

	List<AppNamespace> findByAppIdAndNameIn(String appId, Set<String> namespaceNames);

	AppNamespace findByNameAndIsPublicTrue(String namespaceName);

	List<AppNamespace> findByNameInAndIsPublicTrue(Set<String> namespaceNames);

	List<AppNamespace> findByAppIdAndIsPublic(String appId, boolean isPublic);

	List<AppNamespace> findByAppId(String appId);

	List<AppNamespace> findFirst500ByIdGreaterThanOrderByIdAsc(long id);

}
