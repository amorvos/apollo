package com.ctrip.framework.apollo.common.dto;

import java.util.Date;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class InstanceConfigDTO {

	private Date dataChangeLastModifiedTime;

	private Date releaseDeliveryTime;

	private ReleaseDTO release;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		InstanceConfigDTO that = (InstanceConfigDTO) o;
		return Objects.equals(dataChangeLastModifiedTime, that.dataChangeLastModifiedTime)
				&& Objects.equals(releaseDeliveryTime, that.releaseDeliveryTime)
				&& Objects.equals(release, that.release);
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataChangeLastModifiedTime, releaseDeliveryTime, release);
	}
}
