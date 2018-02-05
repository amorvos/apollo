package com.ctrip.framework.apollo.biz.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ctrip.framework.apollo.biz.AbstractIntegrationTest;
import com.ctrip.framework.apollo.common.entity.AppNamespace;

public class AppNamespaceRepositoryTest extends AbstractIntegrationTest {

	@Autowired
	private AppNamespaceRepository repository;

	@Test
	public void testFindByNameAndIsPublicTrue() throws Exception {
		AppNamespace appNamespace = repository.findByNameAndIsPublicTrue("fx.apollo.config");

		assertEquals("100003171", appNamespace.getAppId());
	}

	@Test
	public void testFindByNameAndNoPublicNamespace() throws Exception {
		AppNamespace appNamespace = repository.findByNameAndIsPublicTrue("application");

		assertNull(appNamespace);
	}
}
