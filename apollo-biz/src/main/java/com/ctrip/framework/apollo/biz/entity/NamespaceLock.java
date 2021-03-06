package com.ctrip.framework.apollo.biz.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

@Entity
@Table(name = "NamespaceLock")
@Where(clause = "isDeleted = 0")
public class NamespaceLock extends BaseEntity {

	@Column(name = "NamespaceId")
	private long namespaceId;

	public long getNamespaceId() {
		return namespaceId;
	}

	public void setNamespaceId(long namespaceId) {
		this.namespaceId = namespaceId;
	}
}
