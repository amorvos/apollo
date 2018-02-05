/**
 * <pre>
 * 热配置并不是一个变化起来并发度很高的事情,因此说这里使用了数据库上锁的模式,
 * 当有用户更改配置的时候,向数据库内插入一条数据
 * </pre>
 */
package com.ctrip.framework.apollo.adminservice.aop;