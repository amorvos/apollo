package com.ctrip.framework.apollo.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ctrip.framework.apollo.core.enums.Env;
import com.ctrip.framework.apollo.portal.entity.bo.ReleaseHistoryBO;
import com.ctrip.framework.apollo.portal.service.ReleaseHistoryService;

@RestController
public class ReleaseHistoryController {

	@Autowired
	private ReleaseHistoryService releaseHistoryService;

	@RequestMapping(value = "/apps/{appId}/envs/{env}/clusters/{clusterName}/namespaces/{namespaceName}/releases/histories", method = RequestMethod.GET)
	public List<ReleaseHistoryBO> findReleaseHistoriesByNamespace(@PathVariable String appId, @PathVariable String env,
			@PathVariable String clusterName, @PathVariable String namespaceName,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {

		return releaseHistoryService.findNamespaceReleaseHistory(appId, Env.valueOf(env), clusterName, namespaceName,
				page, size);
	}

}
