package com.ctrip.framework.apollo.portal.entity.bo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.ctrip.framework.apollo.common.entity.EntityPair;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReleaseHistoryBO {

	private Long id;

	private String appId;

	private String clusterName;

	private String namespaceName;

	private String branchName;

	private String operator;

	private Long releaseId;

	private String releaseTitle;

	private String releaseComment;

	private Date releaseTime;

	private String releaseTimeFormatted;

	private List<EntityPair<String>> configuration;

	private Long previousReleaseId;

	private Integer operation;

	private Map<String, Object> operationContext;
}
