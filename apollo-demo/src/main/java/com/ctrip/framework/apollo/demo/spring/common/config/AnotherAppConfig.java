package com.ctrip.framework.apollo.demo.spring.common.config;

import org.springframework.context.annotation.Configuration;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
@Configuration
@EnableApolloConfig(value = "FX.apollo", order = 11)
public class AnotherAppConfig {
}
