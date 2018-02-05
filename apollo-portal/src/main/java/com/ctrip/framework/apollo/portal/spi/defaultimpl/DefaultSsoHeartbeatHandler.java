package com.ctrip.framework.apollo.portal.spi.defaultimpl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ctrip.framework.apollo.portal.spi.SsoHeartbeatHandler;

/**
 * @author Jason Song(song_s@ctrip.com)
 */
public class DefaultSsoHeartbeatHandler implements SsoHeartbeatHandler {
	@Override
	public void doHeartbeat(HttpServletRequest request, HttpServletResponse response) {
		try {
			response.setContentType("text/plain;charset=utf-8");
			response.getWriter().write("default sso heartbeat handler");
		} catch (IOException e) {
		}
	}
}
