package com.ctrip.framework.apollo.portal.component.emailbuilder;

import org.springframework.stereotype.Component;

import com.ctrip.framework.apollo.core.enums.Env;
import com.ctrip.framework.apollo.portal.entity.bo.ReleaseHistoryBO;

@Component
public class NormalPublishEmailBuilder extends ConfigPublishEmailBuilder {

	private static final String EMAIL_SUBJECT = "[Apollo] 配置发布";

	@Override
	protected String subject() {
		return EMAIL_SUBJECT;
	}

	@Override
	protected String emailContent(Env env, ReleaseHistoryBO releaseHistory) {
		return renderEmailCommonContent(env, releaseHistory);
	}

	@Override
	protected String getTemplateFramework() {
		return portalConfig.emailTemplateFramework();
	}

	@Override
	protected String getDiffModuleTemplate() {
		return portalConfig.emailReleaseDiffModuleTemplate();
	}
}
