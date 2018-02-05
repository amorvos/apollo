package com.ctrip.framework.apollo.portal.api;

import org.springframework.beans.factory.annotation.Autowired;

import com.ctrip.framework.apollo.portal.component.RetryableRestTemplate;

public abstract class API {

	@Autowired
	protected RetryableRestTemplate restTemplate;

}
