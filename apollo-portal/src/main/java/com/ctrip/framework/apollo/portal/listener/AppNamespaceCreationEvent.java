package com.ctrip.framework.apollo.portal.listener;

import org.springframework.context.ApplicationEvent;

import com.ctrip.framework.apollo.common.entity.AppNamespace;
import com.google.common.base.Preconditions;

public class AppNamespaceCreationEvent extends ApplicationEvent {

	public AppNamespaceCreationEvent(Object source) {
		super(source);
	}

	public AppNamespace getAppNamespace() {
		Preconditions.checkState(source != null);
		return (AppNamespace) this.source;
	}
}
