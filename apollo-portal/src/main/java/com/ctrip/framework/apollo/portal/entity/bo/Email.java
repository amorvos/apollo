package com.ctrip.framework.apollo.portal.entity.bo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Email {

	private String senderEmailAddress;

	private List<String> recipients;

	private String subject;

	private String body;

}
