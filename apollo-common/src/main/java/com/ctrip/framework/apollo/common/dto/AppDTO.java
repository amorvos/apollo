package com.ctrip.framework.apollo.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AppDTO extends BaseDTO {

	private Long id;

	private String name;

	private String appId;

	private String orgId;

	private String orgName;

	private String ownerName;

	private String ownerEmail;
}
