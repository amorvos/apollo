package com.ctrip.framework.apollo.common.dto;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReleaseHistoryDTO extends BaseDTO {

	private Long id;

	private String appId;

	private String clusterName;

	private String namespaceName;

	private String branchName;

	private Long releaseId;

	private Long previousReleaseId;

	private Integer operation;

	private Map<String, Object> operationContext;
}
