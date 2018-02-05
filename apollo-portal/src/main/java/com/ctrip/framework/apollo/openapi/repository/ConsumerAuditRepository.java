package com.ctrip.framework.apollo.openapi.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ctrip.framework.apollo.openapi.entity.ConsumerAudit;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
public interface ConsumerAuditRepository extends PagingAndSortingRepository<ConsumerAudit, Long> {
}
