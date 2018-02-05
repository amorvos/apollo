package com.ctrip.framework.apollo.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReleaseDTO extends BaseDTO {

	private Long id;

	private String releaseKey;

	private String name;

	private String appId;

	private String clusterName;

	private String namespaceName;

	private String configurations;

	private String comment;

	private Boolean isAbandoned;

}
