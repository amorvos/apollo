package com.ctrip.framework.apollo.common.dto;

import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class InstanceDTO {

	private Long id;

	private String appId;

	private String clusterName;

	private String dataCenter;

	private String ip;

	private List<InstanceConfigDTO> configs;

	private Date dataChangeCreatedTime;
}
