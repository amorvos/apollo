package com.ctrip.framework.apollo.common.dto;

import java.util.List;

import org.springframework.data.domain.Pageable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class PageDTO<T> {

	private final Long total;

	private final List<T> content;

	private final Integer page;

	private final Integer size;

	public PageDTO(List<T> content, Pageable pageable, long total) {
		this.total = total;
		this.content = content;
		this.page = pageable.getPageNumber();
		this.size = pageable.getPageSize();
	}
}
