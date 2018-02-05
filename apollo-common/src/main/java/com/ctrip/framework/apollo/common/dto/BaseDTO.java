package com.ctrip.framework.apollo.common.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class BaseDTO {

	protected String dataChangeCreatedBy;

	protected String dataChangeLastModifiedBy;

	protected Date dataChangeCreatedTime;

	protected Date dataChangeLastModifiedTime;
}
