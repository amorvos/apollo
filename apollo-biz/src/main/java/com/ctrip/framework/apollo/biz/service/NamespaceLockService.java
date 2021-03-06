package com.ctrip.framework.apollo.biz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ctrip.framework.apollo.biz.entity.NamespaceLock;
import com.ctrip.framework.apollo.biz.repository.NamespaceLockRepository;

@Service
public class NamespaceLockService {

	@Autowired
	private NamespaceLockRepository namespaceLockRepository;

	public NamespaceLock findLock(Long namespaceId) {
		return namespaceLockRepository.findByNamespaceId(namespaceId);
	}

	@Transactional(rollbackFor = Exception.class)
	public NamespaceLock tryLock(NamespaceLock lock) {
		return namespaceLockRepository.save(lock);
	}

	@Transactional(rollbackFor = Exception.class)
	public void unlock(Long namespaceId) {
		namespaceLockRepository.deleteByNamespaceId(namespaceId);
	}
}
