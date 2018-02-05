package com.ctrip.framework.apollo.biz.customize;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.biz.config.BizConfig;
import com.ctrip.framework.apollo.common.customize.LoggingCustomizer;

@Component
@Profile("ctrip")
public class BizLoggingCustomizer extends LoggingCustomizer {

	@Autowired
	private BizConfig bizConfig;

	@Override
	protected String cloggingUrl() {
		return bizConfig.cloggingUrl();
	}

	@Override
	protected String cloggingPort() {
		return bizConfig.cloggingPort();
	}
}
