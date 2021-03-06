package com.ctrip.framework.apollo.biz;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.common.ApolloCommonConfig;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackageClasses = { ApolloCommonConfig.class, ApolloBizConfig.class })
public class BizTestConfiguration {

}
