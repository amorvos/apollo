package com.ctrip.framework.apollo.portal.entity.model;

import com.ctrip.framework.apollo.core.utils.StringUtils;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NamespaceReleaseModel implements Verifiable {

	private String appId;

	private String env;

	private String clusterName;

	private String namespaceName;

	private String releaseTitle;

	private String releaseComment;

	private String releasedBy;

	private Boolean isEmergencyPublish;

	@Override
	public boolean isInvalid() {
		return StringUtils.isContainEmpty(appId, env, clusterName, namespaceName, releaseTitle);
	}
}
