package com.ctrip.framework.apollo.biz.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.biz.entity.NamespaceLock;

public interface NamespaceLockRepository extends PagingAndSortingRepository<NamespaceLock, Long> {

	NamespaceLock findByNamespaceId(Long namespaceId);

	Long deleteByNamespaceId(Long namespaceId);

}
