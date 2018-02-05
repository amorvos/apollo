package com.ctrip.framework.apollo.common.dto;

import java.util.Set;

import com.google.common.collect.Sets;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GrayReleaseRuleDTO extends BaseDTO {

	private String appId;

	private String clusterName;

	private String namespaceName;

	private String branchName;

	private Set<GrayReleaseRuleItemDTO> ruleItems;

	private Long releaseId;

	public GrayReleaseRuleDTO(String appId, String clusterName, String namespaceName, String branchName) {
		this.appId = appId;
		this.clusterName = clusterName;
		this.namespaceName = namespaceName;
		this.branchName = branchName;
		this.ruleItems = Sets.newHashSet();
	}
}
