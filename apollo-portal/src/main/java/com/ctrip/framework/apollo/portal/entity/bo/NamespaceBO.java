package com.ctrip.framework.apollo.portal.entity.bo;

import java.util.List;

import com.ctrip.framework.apollo.common.dto.NamespaceDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class NamespaceBO {

	private NamespaceDTO baseInfo;

	private Integer itemModifiedCnt;

	private List<ItemBO> items;

	private String format;

	private Boolean isPublic;

	private String parentAppId;

	private String comment;
}
