package com.ctrip.framework.apollo.portal.entity.bo;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class KVEntity {

	private String key;

	private String value;

	public KVEntity(String key, String value) {
		this.key = key;
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		KVEntity kvEntity = (KVEntity) o;
		return Objects.equals(key, kvEntity.key)
				//
				&& Objects.equals(value, kvEntity.value);
	}

	@Override
	public int hashCode() {

		return Objects.hash(key, value);
	}
}
