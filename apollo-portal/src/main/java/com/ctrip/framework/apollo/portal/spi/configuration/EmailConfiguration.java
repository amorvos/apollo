package com.ctrip.framework.apollo.portal.spi.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.portal.spi.EmailService;
import com.ctrip.framework.apollo.portal.spi.defaultimpl.DefaultEmailService;

@Configuration
public class EmailConfiguration {

	@Configuration
	public static class DefaultEmailConfiguration {
		@Bean
		@ConditionalOnMissingBean(EmailService.class)
		public EmailService defaultEmailService() {
			return new DefaultEmailService();
		}
	}

}
