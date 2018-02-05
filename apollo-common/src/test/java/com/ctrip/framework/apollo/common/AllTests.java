package com.ctrip.framework.apollo.common;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ctrip.framework.apollo.common.conditional.ConditionalOnProfileTest;
import com.ctrip.framework.apollo.common.utils.InputValidatorTest;

@RunWith(Suite.class)
@SuiteClasses({ InputValidatorTest.class, ConditionalOnProfileTest.class })
public class AllTests {

}
