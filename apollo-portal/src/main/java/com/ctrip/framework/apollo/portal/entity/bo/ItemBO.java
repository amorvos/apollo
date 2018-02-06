package com.ctrip.framework.apollo.portal.entity.bo;

import com.ctrip.framework.apollo.common.dto.ItemDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ItemBO {

	private ItemDTO item;

	private Boolean isModified;

	private Boolean isDeleted;

	private String oldValue;

	private String newValue;

}
