package com.ctrip.framework.apollo.portal.entity.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.ctrip.framework.apollo.common.entity.BaseEntity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Entity
@Table(name = "ServerConfig")
@SQLDelete(sql = "Update ServerConfig set isDeleted = 1 where id = ?")
@Where(clause = "isDeleted = 0")
public class ServerConfig extends BaseEntity {
	@Column(name = "Key", nullable = false)
	private String key;

	@Column(name = "Value", nullable = false)
	private String value;

	@Column(name = "Comment", nullable = false)
	private String comment;
}
