package com.ctrip.framework.apollo.portal.entity.model;

import java.util.List;

import org.springframework.util.CollectionUtils;

import com.ctrip.framework.apollo.common.dto.ItemDTO;
import com.ctrip.framework.apollo.portal.entity.vo.NamespaceIdentifier;

public class NamespaceSyncModel implements Verifiable {

	private List<NamespaceIdentifier> syncToNamespaces;
	private List<ItemDTO> syncItems;

	@Override
	public boolean isInvalid() {
		if (CollectionUtils.isEmpty(syncToNamespaces) || CollectionUtils.isEmpty(syncItems)) {
			return true;
		}
		for (NamespaceIdentifier namespaceIdentifier : syncToNamespaces) {
			if (namespaceIdentifier.isInvalid()) {
				return true;
			}
		}
		return false;
	}

	public List<NamespaceIdentifier> getSyncToNamespaces() {
		return syncToNamespaces;
	}

	public void setSyncToNamespaces(List<NamespaceIdentifier> syncToNamespaces) {
		this.syncToNamespaces = syncToNamespaces;
	}

	public List<ItemDTO> getSyncItems() {
		return syncItems;
	}

	public void setSyncItems(List<ItemDTO> syncItems) {
		this.syncItems = syncItems;
	}
}
