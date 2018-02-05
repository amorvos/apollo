package com.ctrip.framework.apollo.common.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ItemDTO extends BaseDTO {

	private Long id;

	private Long namespaceId;

	private String key;

	private String value;

	private String comment;

	private Integer lineNum;

	public ItemDTO() {

	}

	public ItemDTO(String key, String value, String comment, int lineNum) {
		this.key = key;
		this.value = value;
		this.comment = comment;
		this.lineNum = lineNum;
	}
}
