package com.ctrip.framework.apollo.common.constants;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.ctrip.framework.apollo.common.dto.GrayReleaseRuleItemDTO;
import com.google.gson.reflect.TypeToken;

public interface GsonType {

	Type CONFIG = new TypeToken<Map<String, String>>() {
	}.getType();

	Type RULE_ITEMS = new TypeToken<List<GrayReleaseRuleItemDTO>>() {
	}.getType();

}
