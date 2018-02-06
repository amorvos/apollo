package com.ctrip.framework.apollo.portal.entity.bo;

import java.util.Set;

import com.ctrip.framework.apollo.common.dto.ReleaseDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ReleaseBO {

	private ReleaseDTO baseInfo;

	private Set<KVEntity> items;

}
