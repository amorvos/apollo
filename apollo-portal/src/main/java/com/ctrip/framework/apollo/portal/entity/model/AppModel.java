package com.ctrip.framework.apollo.portal.entity.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AppModel {

	private String name;

	private String appId;

	private String orgId;

	private String orgName;

	private String ownerName;

	private Set<String> admins;
}
