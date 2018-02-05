package com.ctrip.framework.apollo.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NamespaceDTO extends BaseDTO {

	private Long id;

	private String appId;

	private String clusterName;

	private String namespaceName;
}
