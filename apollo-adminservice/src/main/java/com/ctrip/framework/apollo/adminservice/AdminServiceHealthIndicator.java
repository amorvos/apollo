package com.ctrip.framework.apollo.adminservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.biz.service.AppService;

/***
 * 这里认为数据库能查到数据就是应用存活状态
 */
@Component
public class AdminServiceHealthIndicator implements HealthIndicator {

	@Autowired
	private AppService appService;

	@Override
	public Health health() {
		int errorCode = check();
		if (errorCode != 0) {
			return Health.down().withDetail("Error Code", errorCode).build();
		}
		return Health.up().build();
	}

	private int check() {
		PageRequest pageable = new PageRequest(0, 1);
		appService.findAll(pageable);
		return 0;
	}

}
