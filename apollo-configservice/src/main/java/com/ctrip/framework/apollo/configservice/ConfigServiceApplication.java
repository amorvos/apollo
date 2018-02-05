package com.ctrip.framework.apollo.configservice;

import org.springframework.boot.actuate.system.ApplicationPidFileWriter;
import org.springframework.boot.actuate.system.EmbeddedServerPortFileWriter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ctrip.framework.apollo.biz.ApolloBizConfig;
import com.ctrip.framework.apollo.common.ApolloCommonConfig;
import com.ctrip.framework.apollo.metaservice.ApolloMetaServiceConfig;

/**
 * EurekaServer作为注册中心
 */
@EnableEurekaServer
@EnableAspectJAutoProxy
@EnableAutoConfiguration
@Configuration
@EnableTransactionManagement
@PropertySource(value = { "classpath:configservice.properties" })
@ComponentScan(basePackageClasses = { ApolloCommonConfig.class, ApolloBizConfig.class, ConfigServiceApplication.class,
		ApolloMetaServiceConfig.class })
public class ConfigServiceApplication {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext context = new SpringApplicationBuilder(ConfigServiceApplication.class).run(args);
		// 创建一个包含应用PID的文件（默认位于应用目录，文件名为application.pid）
		context.addApplicationListener(new ApplicationPidFileWriter());
		// 创建一个或多个包含内嵌服务器端口的文件（默认位于应用目录，文件名为application.port）
		context.addApplicationListener(new EmbeddedServerPortFileWriter());
	}

}
