package com.ctrip.framework.apollo.common.config;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.util.CollectionUtils;

import com.ctrip.framework.apollo.core.utils.ApolloThreadFactory;
import com.ctrip.framework.apollo.tracer.Tracer;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;

public abstract class RefreshableConfig {

	private static final Logger logger = LoggerFactory.getLogger(RefreshableConfig.class);

	protected Splitter splitter = Splitter.on(LIST_SEPARATOR).omitEmptyStrings().trimResults();

	private List<RefreshablePropertySource> propertySources;

	// TimeUnit: second
	private static final int CONFIG_REFRESH_INTERVAL = 60;

	private static final String LIST_SEPARATOR = ",";

	@Autowired
	private ConfigurableEnvironment environment;

	/**
	 * register refreshable property source. Notice: The front property source has
	 * higher priority.
	 */
	protected abstract List<RefreshablePropertySource> getRefreshablePropertySources();

	@PostConstruct
	public void setup() {

		propertySources = getRefreshablePropertySources();
		if (CollectionUtils.isEmpty(propertySources)) {
			throw new IllegalStateException("Property sources can not be empty.");
		}

		// add property source to environment
		for (RefreshablePropertySource propertySource : propertySources) {
			propertySource.refresh();
			environment.getPropertySources().addLast(propertySource);
		}

		// task to update configs
		ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1,
				new BasicThreadFactory.Builder().namingPattern("config-refresher-%d").daemon(true).build());

		executorService.scheduleWithFixedDelay(() -> {
			try {
				propertySources.forEach(RefreshablePropertySource::refresh);
			} catch (Throwable t) {
				logger.error("Refresh configs failed.", t);
				Tracer.logError("Refresh configs failed.", t);
			}
		}, CONFIG_REFRESH_INTERVAL, CONFIG_REFRESH_INTERVAL, TimeUnit.SECONDS);
	}

	public int getIntProperty(String key, int defaultValue) {
		try {
			String value = getValue(key);
			return value == null ? defaultValue : Integer.parseInt(value);
		} catch (Throwable e) {
			Tracer.logError("Get int property failed.", e);
			return defaultValue;
		}
	}

	public boolean getBooleanProperty(String key, boolean defaultValue) {
		try {
			String value = getValue(key);
			return value == null ? defaultValue : "true".equals(value);
		} catch (Throwable e) {
			Tracer.logError("Get boolean property failed.", e);
			return defaultValue;
		}
	}

	public String[] getArrayProperty(String key, String[] defaultValue) {
		try {
			String value = getValue(key);
			return Strings.isNullOrEmpty(value) ? defaultValue : value.split(LIST_SEPARATOR);
		} catch (Throwable e) {
			Tracer.logError("Get array property failed.", e);
			return defaultValue;
		}
	}

	public String getValue(String key, String defaultValue) {
		try {
			return environment.getProperty(key, defaultValue);
		} catch (Throwable e) {
			Tracer.logError("Get value failed.", e);
			return defaultValue;
		}
	}

	public String getValue(String key) {
		return environment.getProperty(key);
	}

}
