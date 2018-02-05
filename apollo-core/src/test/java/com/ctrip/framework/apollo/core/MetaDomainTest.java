package com.ctrip.framework.apollo.core;

import org.junit.Assert;
import org.junit.Test;

import com.ctrip.framework.apollo.core.enums.Env;

public class MetaDomainTest {

	@Test
	public void testGetMetaDomain() {
		Assert.assertEquals("http://localhost:8080", MetaDomainConsts.getDomain(Env.LOCAL));
		Assert.assertEquals("http://dev:8080", MetaDomainConsts.getDomain(Env.DEV));
		Assert.assertEquals(MetaDomainConsts.DEFAULT_META_URL, MetaDomainConsts.getDomain(Env.PRO));
	}
}
