package com.sym.singleton;

import java.util.ResourceBundle;

public class PropertiesHelper {

	private ResourceBundle props = null;
	private static PropertiesHelper propsInstance = null;

	private PropertiesHelper() {
		props = ResourceBundle.getBundle("AppConfig");
	}

	public static PropertiesHelper getInstance() {
		if (propsInstance == null) {
			propsInstance = new PropertiesHelper();
		}
		return propsInstance;
	}

	public String getString(String key) {
		return props.getString(key);

	}

}
