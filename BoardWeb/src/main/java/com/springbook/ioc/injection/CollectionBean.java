package com.springbook.ioc.injection;

import java.util.Map;


public class CollectionBean {
	private Map<String, String> addressMap;

	public void setAddressMap(Map<String, String> addressMap) {
		this.addressMap = addressMap;
	}

	public Map<String, String> getAddressMap() {
		return addressMap;
	}
}
