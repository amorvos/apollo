package com.ctrip.framework.apollo.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ClusterDTO extends BaseDTO {

	private Long id;

	private String name;

	private String appId;

	private Long parentClusterId;

}
