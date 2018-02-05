package com.ctrip.framework.apollo.portal.component.txtresolver;

import java.util.List;

import com.ctrip.framework.apollo.common.dto.ItemChangeSets;
import com.ctrip.framework.apollo.common.dto.ItemDTO;

/**
 * users can modify config in text mode.so need resolve text.
 */
public interface ConfigTextResolver {

	ItemChangeSets resolve(long namespaceId, String configText, List<ItemDTO> baseItems);

}
