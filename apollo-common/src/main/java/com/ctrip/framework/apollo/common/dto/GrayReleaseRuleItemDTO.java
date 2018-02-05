package com.ctrip.framework.apollo.common.dto;

import java.util.Objects;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class GrayReleaseRuleItemDTO {

	public static final String ALL_IP = "*";

	private Set<String> clientIpList;

	private String clientAppId;

	public GrayReleaseRuleItemDTO(String clientAppId, Set<String> clientIpList) {
		this.clientAppId = clientAppId;
		this.clientIpList = clientIpList;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		GrayReleaseRuleItemDTO that = (GrayReleaseRuleItemDTO) o;
		return Objects.equals(clientIpList, that.clientIpList)
				//
				&& Objects.equals(clientAppId, that.clientAppId);
	}

	@Override
	public int hashCode() {

		return Objects.hash(clientIpList, clientAppId);
	}
}
