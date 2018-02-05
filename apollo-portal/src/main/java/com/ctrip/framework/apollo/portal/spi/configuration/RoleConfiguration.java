package com.ctrip.framework.apollo.portal.spi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.portal.service.RoleInitializationService;
import com.ctrip.framework.apollo.portal.service.RolePermissionService;
import com.ctrip.framework.apollo.portal.spi.defaultimpl.DefaultRoleInitializationService;
import com.ctrip.framework.apollo.portal.spi.defaultimpl.DefaultRolePermissionService;

/**
 * @author Timothy Liu(timothy.liu@cvte.com)
 */
@Configuration
public class RoleConfiguration {
	@Bean
	public RoleInitializationService roleInitializationService() {
		return new DefaultRoleInitializationService();
	}

	@Bean
	public RolePermissionService rolePermissionService() {
		return new DefaultRolePermissionService();
	}
}
