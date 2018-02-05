package com.ctrip.framework.apollo.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class AppNamespaceDTO extends BaseDTO {

	private Long id;

	private String name;

	private String appId;

	private String comment;

	private String format;

	private Boolean isPublic;

}
