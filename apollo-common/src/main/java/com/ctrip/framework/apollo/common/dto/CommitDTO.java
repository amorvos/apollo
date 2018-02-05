package com.ctrip.framework.apollo.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CommitDTO extends BaseDTO {

	private String changeSets;

	private String appId;

	private String clusterName;

	private String namespaceName;

	private String comment;
}
