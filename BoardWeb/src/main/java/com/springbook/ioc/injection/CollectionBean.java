package com.springbook.ioc.injection;

import java.util.Map;

import org.springframework.web.servlet.mvc.Controller;

public class CollectionBean {
	private Map<String, Controller> addressList;

	public void setAddressList(Map<String, Controller> addressList) {
		this.addressList = addressList;
	}
	
}
