package com.ctrip.framework.apollo.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ctrip.framework.apollo.core.utils.StringUtils;

public final class InputValidator {

	public static final String INVALID_NAMESPACE_NAMESPACE_MESSAGE = "不允许以.json, .yml, .yaml, .xml, .properties结尾";

	public static final String INVALID_CLUSTER_NAMESPACE_MESSAGE = "只允许输入数字，字母和符号 - _ .";

	private static final String APP_NAMESPACE_VALIDATOR = "[a-zA-Z0-9._-]+(?<!\\.(json|yml|yaml|xml|properties))$";

	private static final String CLUSTER_NAMESPACE_VALIDATOR = "[0-9a-zA-Z_.-]+";

	private static final Pattern CLUSTER_NAMESPACE_PATTERN = Pattern.compile(CLUSTER_NAMESPACE_VALIDATOR);

	private static final Pattern APP_NAMESPACE_PATTERN = Pattern.compile(APP_NAMESPACE_VALIDATOR);

	public static boolean isValidClusterNamespace(String input) {
		Matcher matcher = CLUSTER_NAMESPACE_PATTERN.matcher(input);
		return matcher.matches();
	}

	public static boolean isValidAppNamespace(String name) {
		return !StringUtils.isEmpty(name) && CLUSTER_NAMESPACE_PATTERN.matcher(name).matches()
				&& APP_NAMESPACE_PATTERN.matcher(name).matches();
	}
}
